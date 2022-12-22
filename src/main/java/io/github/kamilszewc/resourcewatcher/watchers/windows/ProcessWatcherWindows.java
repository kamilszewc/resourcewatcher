package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.core.CommandCaller;
import io.github.kamilszewc.resourcewatcher.exceptions.NoProcessFoundException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.ProcessWatcher;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ProcessWatcher class - Windows specialization
 */
public class ProcessWatcherWindows implements ProcessWatcher {

    private String getWmicInfo(Long processId, String variable) throws IOException, NoProcessFoundException {
        String command = "wmic process where \"processID=" + processId + "\"" + " get " + variable;
        String result = CommandCaller.call(command);
        if (result.isBlank()) {
            throw new NoProcessFoundException();
        }

        return Arrays.stream(result.split("\n"))
                .filter(line -> !line.isBlank())
                .map(String::trim)
                .skip(1)
                .findFirst()
                .get();
    }

    @Override
    public Memory getProcessResidentSetSizeMemory(Long processId) throws IOException, NoProcessFoundException {

        Long memory = Long.valueOf(getWmicInfo(processId, "workingsetsize"));
        return new Memory(memory);
    }

    @Override
    public Memory getProcessVirtualMemory(Long processId) throws IOException, NoProcessFoundException {

        Long memory = Long.valueOf(getWmicInfo(processId, "virtualsize"));
        return new Memory(memory);
    }

    @Override
    public Set<Long> getChildrenTree(Long processId) throws NoProcessFoundException, IOException {
        String result = CommandCaller.call("wmic process where \"ParentProcessId=" + processId +"\" get ProcessId");
        if (result.trim().isEmpty()) {
            throw new NoProcessFoundException();
        }

        List<Long> values = Arrays.stream(result.split("\n"))
                .skip(1)
                .map(String::trim)
                .filter(element -> !element.isBlank())
                .map(Long::valueOf)
                .collect(Collectors.toList());

        Set<Long> processIds = new HashSet<>();
        processIds.add(processId);
        processIds.addAll(values);

        for (Long value : values) {
            try {
                Set<Long> subtree = getChildrenTree(value);
                processIds.addAll(subtree);
            } catch (NoProcessFoundException ex) {
                continue;
            }
        }

        return processIds;
    }

    @Override
    public Memory getProcessResidentSetSizeWithChildrenMemory(Long processId) throws NoProcessFoundException, IOException {
        Set<Long> processIds = getChildrenTree(processId);
        Long memory = 0L;
        for (Long id: processIds) {
            memory += getProcessResidentSetSizeMemory(id).getB();
        }
        return new Memory(memory);
    }

    @Override
    public Memory getProcessVirtualWithChildrenMemory(Long processId) throws NoProcessFoundException, IOException {
        Set<Long> processIds = getChildrenTree(processId);
        Long memory = 0L;
        for (Long id: processIds) {
            memory += getProcessVirtualMemory(id).getB();
        }
        return new Memory(memory);
    }

}

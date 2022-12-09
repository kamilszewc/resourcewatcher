package io.github.kamilszewc.resourcewatcher.watchers.linux;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.core.ProcessCommand;
import io.github.kamilszewc.resourcewatcher.exceptions.NoProcessFoundException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.ProcessWatcher;

import java.io.IOError;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class ProcessWatcherLinux implements ProcessWatcher {

    private Long getSmapValue(Long processId, String key) throws IOException {

        String result = ProcessCommand.call("cat /proc/" + processId + "/smaps");
        List<String> lines = Arrays.stream(result.split("\n")).collect(Collectors.toList());
        List<Long> values = lines.stream()
                .filter(entry -> entry.contains(key))
                .map(entry -> entry.split(":")[1].strip())
                .map(entry -> entry.split(" ")[0])
                .map(entry -> Long.valueOf(entry))
                .collect(Collectors.toList());

        return values.stream().reduce(0l, Long::sum);
    }

    @Override
    public Memory getProcessProportionalSetSizeMemory(Long processId) throws IOException {

        Long value = getSmapValue(processId, "Pss");

        return new Memory(value * 1024);
    }

    @Override
    public Memory getProcessProportionalSetSizeWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException {
        Set<Long> childrenProcesses = getChildrenTree(processId);

        Long value = 0L;
        for (Long ps : childrenProcesses) {
            value += getProcessProportionalSetSizeMemory(ps).getKB();
        }

        return new Memory(value * 1024);
    }

    @Override
    public Memory getProcessUniqueSetSizeMemory(Long processId) throws IOError, IOException, NoProcessFoundException {
        Long valuePrivateClean = getSmapValue(processId, "Private_Clean");
        Long valuePrivateDirty = getSmapValue(processId, "Private_Dirty");
        Long value = valuePrivateClean + valuePrivateDirty;

        return new Memory(value * 1024);
    }

    @Override
    public Memory getProcessUniqueSetSizeWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException {
        Set<Long> childrenProcesses = getChildrenTree(processId);

        Long value = 0L;
        for (Long ps : childrenProcesses) {
            value += getProcessUniqueSetSizeMemory(ps).getKB();
        }

        return new Memory(value * 1024);
    }


    @Override
    public Memory getProcessResidentSetSizeMemory(Long processId) throws IOError, IOException, NoProcessFoundException {

        String result = ProcessCommand.call("ps -o rss " + processId);
        String[] lines = result.split("\n");
        try {
            Long value = Long.valueOf(lines[1].trim());
            return new Memory(value * 1024);
        } catch (Exception ex) {
            throw new NoProcessFoundException();
        }
    }

    @Override
    public Memory getProcessVirtualMemory(Long processId) throws IOError, IOException, NoProcessFoundException {

        String result = ProcessCommand.call("ps -o vsz " + processId);
        String[] lines = result.split("\n");
        try {
            Long value = Long.valueOf(lines[1].trim());
            return new Memory(value * 1024);
        } catch (Exception ex) {
            throw new NoProcessFoundException();
        }
    }

    @Override
    public Set<Long> getChildrenTree(final Long processId) throws IOError, IOException {

        String result = ProcessCommand.call("pgrep -P " + processId);
        String[] lines = result.split("\n");

        Set<Long> processIds = new HashSet<>();
        processIds.add(processId);

        for (String line : lines) {
            if (line.length() > 0) {
                Integer value = Integer.valueOf(line.trim());
                Set<Long> subtree = getChildrenTree((long)value);
                processIds.addAll(subtree);
            }
        }

        return processIds;
    }

    @Override
    public Memory getProcessResidentSetSizeWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException {
        Set<Long> childrenProcesses = getChildrenTree(processId);

        Long value = 0L;
        for (Long ps : childrenProcesses) {
            value += getProcessResidentSetSizeMemory(ps).getKB();
        }

        return new Memory(value * 1024);
    }

    @Override
    public Memory getProcessVirtualWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException {

        Set<Long> childrenProcesses = getChildrenTree(processId);

        Long value = 0L;
        for (Long ps : childrenProcesses) {
            value += getProcessVirtualMemory(ps).getKB();
        }

        return new Memory(value * 1024);
    }

    @Override
    public Duration getProcessCpuTime(Long processId) throws IOError, IOException {

        String result = ProcessCommand.call("ps -o time " + processId);
        String[] lines = result.split("\n");
        System.out.println(lines[1].trim());
        Duration duration = Duration.parse(lines[1].trim());

        return duration;
    }

    @Override
    public Duration getProcessCpuTimeWithChildren(Long processId) throws IOError, IOException {

        Set<Long> childrenProcesses = getChildrenTree(processId);
        Duration duration = Duration.ZERO;
        for (Long ps : childrenProcesses) {
            // TODO
        }
        return duration;
    }

}

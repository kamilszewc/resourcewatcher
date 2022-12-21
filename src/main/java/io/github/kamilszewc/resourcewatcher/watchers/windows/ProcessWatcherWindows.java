package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.core.ProcessCommand;
import io.github.kamilszewc.resourcewatcher.exceptions.NoProcessFoundException;
import io.github.kamilszewc.resourcewatcher.exceptions.NotImplementedException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.ProcessWatcher;

import java.io.IOError;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ProcessWatcherWindows implements ProcessWatcher {

    private boolean checkIfProcessExist(Long processId) throws NoProcessFoundException {
        String command = "wmic process where \"processID=" + processId + "\"" + " get caption";
        try {
            String result = ProcessCommand.call(command);
            return true;
        } catch (Exception ex) {
            throw new NoProcessFoundException();
        }
    }

    private String getWmicInfo(Long processId, String variable) throws IOException {
        String command = "wmic process where \"processID=" + processId + "\"" + " get " + variable;
        String result = ProcessCommand.call(command);
        return Arrays.stream(result.split("\n"))
                .filter(line -> !line.isBlank())
                .map(String::trim)
                .skip(1)
                .findFirst()
                .get();
    }

    @Override
    public Memory getProcessResidentSetSizeMemory(Long processId) throws IOException, NoProcessFoundException {
        checkIfProcessExist(processId);
        Long memory = Long.valueOf(getWmicInfo(processId, "workingsetsize"));
        return new Memory(memory);
    }

    @Override
    public Memory getProcessVirtualMemory(Long processId) throws IOException, NoProcessFoundException {
        checkIfProcessExist(processId);
        Long memory = Long.valueOf(getWmicInfo(processId, "virtualsize"));
        return new Memory(memory);
    }

    @Override
    public Set<Long> getChildrenTree(Long processId) throws NoProcessFoundException, IOException {
        checkIfProcessExist(processId);
        return null;
    }

    @Override
    public Memory getProcessResidentSetSizeWithChildrenMemory(Long processId) throws NoProcessFoundException, IOException {
        checkIfProcessExist(processId);
        return null;
    }

    @Override
    public Memory getProcessVirtualWithChildrenMemory(Long processId) throws NoProcessFoundException, IOException {
        checkIfProcessExist(processId);
        return null;
    }

    @Override
    public Long getProcessCpuTime(Long processId) throws NoProcessFoundException, IOException {
        checkIfProcessExist(processId);
        return null;
    }

    @Override
    public Long getProcessCpuTimeWithChildren(Long processId) throws NoProcessFoundException, IOException {
        checkIfProcessExist(processId);
        return null;
    }

}

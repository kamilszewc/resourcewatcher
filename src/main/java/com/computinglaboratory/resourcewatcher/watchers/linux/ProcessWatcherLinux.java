package com.computinglaboratory.resourcewatcher.watchers.linux;

import com.computinglaboratory.resourcewatcher.core.Memory;
import com.computinglaboratory.resourcewatcher.core.ProcessCommand;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.ProcessWatcher;

import java.io.IOError;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class ProcessWatcherLinux implements ProcessWatcher {
    @Override
    public Memory getProcessResidentSetSizeMemory(Long processId) throws IOError, IOException {

        String result = ProcessCommand.call("ps -o rss" + processId);
        String[] lines = result.split("\n");
        Long value = Long.valueOf(lines[1].trim());

        return new Memory(value);
    }

    @Override
    public Memory getProcessVirtualMemory(Long processId) throws IOError, IOException {

        String result = ProcessCommand.call("ps -o vsz" + processId);
        String[] lines = result.split("\n");
        Long value = Long.valueOf(lines[1].trim());

        return new Memory(value);
    }

    @Override
    public Set<Long> getChildrenTree(final Long processId) throws IOError, IOException {

        String result = ProcessCommand.call("pgrep -P " + processId);
        String[] lines = result.split("\n");

        Set<Long> processIds = new HashSet<>();
        processIds.add(processId);

        for (String line : lines) {
            Long value = Long.valueOf(line.trim());
            Set<Long> subtree = getChildrenTree(value);
            processIds.addAll(subtree);
        }

        return processIds;
    }

    @Override
    public Memory getProcessResidentSetSizeWithChildrenMemory(Long processId) throws IOError, IOException {
        Set<Long> childrenProcesses = getChildrenTree(processId);

        Long value = 0L;
        for (Long ps : childrenProcesses) {
            value += getProcessResidentSetSizeMemory(ps).KB();
        }

        return new Memory(value);
    }

    @Override
    public Memory getProcessVirtualWithChildrenMemory(Long processId) throws IOError, IOException {

        Set<Long> childrenProcesses = getChildrenTree(processId);

        Long value = 0L;
        for (Long ps : childrenProcesses) {
            value += getProcessVirtualMemory(ps).KB();
        }

        return new Memory(value);
    }

    @Override
    public Duration getProcessCpuTime(Long processId) throws IOError, IOException {

        String result = ProcessCommand.call("ps -o time " + processId);
        String[] lines = result.split("\n");
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

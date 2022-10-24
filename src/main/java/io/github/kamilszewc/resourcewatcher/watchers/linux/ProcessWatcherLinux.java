package io.github.kamilszewc.resourcewatcher.watchers.linux;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.core.ProcessCommand;
import io.github.kamilszewc.resourcewatcher.exceptions.NoProcessFoundException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.ProcessWatcher;

import java.io.IOError;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class ProcessWatcherLinux implements ProcessWatcher {
    @Override
    public Memory getProcessResidentSetSizeMemory(Long processId) throws IOError, IOException, NoProcessFoundException {

        String result = ProcessCommand.call("ps -o rss " + processId);
        String[] lines = result.split("\n");
        try {
            Long value = Long.valueOf(lines[1].trim());
            return new Memory(value);
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
            return new Memory(value);
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
            value += getProcessResidentSetSizeMemory(ps).KB();
        }

        return new Memory(value);
    }

    @Override
    public Memory getProcessVirtualWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException {

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

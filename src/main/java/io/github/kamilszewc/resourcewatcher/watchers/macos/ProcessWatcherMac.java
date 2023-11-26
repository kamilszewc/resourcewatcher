package io.github.kamilszewc.resourcewatcher.watchers.macos;

import io.github.kamilszewc.resourcewatcher.core.CommandCaller;
import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.exceptions.NoProcessFoundException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.ProcessWatcher;

import java.io.IOException;
import java.util.*;

/**
 * ProcessWatcher class - MacOS specialization
 */
public class ProcessWatcherMac implements ProcessWatcher {

    /**
     * Constructor
     */
    public ProcessWatcherMac() {}

    @Override
    public Memory getProcessResidentSetSizeMemory(Long processId) throws IOException, NoProcessFoundException {

        String result = CommandCaller.call("ps -o rss " + processId);
        String[] lines = result.split("\n");
        try {
            Long value = Long.valueOf(lines[1].trim());
            return new Memory(value * 1024);
        } catch (Exception ex) {
            throw new NoProcessFoundException();
        }
    }

    @Override
    public Memory getProcessVirtualMemory(Long processId) throws IOException, NoProcessFoundException {

        String result = CommandCaller.call("ps -o vsz " + processId);
        String[] lines = result.split("\n");
        try {
            Long value = Long.valueOf(lines[1].trim());
            return new Memory(value * 1024);
        } catch (Exception ex) {
            throw new NoProcessFoundException();
        }
    }

    @Override
    public Set<Long> getChildrenTree(final Long processId) throws IOException {

        String result = CommandCaller.call("pgrep -P " + processId);
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
    public Memory getProcessResidentSetSizeWithChildrenMemory(Long processId) throws IOException, NoProcessFoundException {
        Set<Long> childrenProcesses = getChildrenTree(processId);

        Long value = 0L;
        for (Long ps : childrenProcesses) {
            value += getProcessResidentSetSizeMemory(ps).getKB();
        }

        return new Memory(value * 1024);
    }

    @Override
    public Memory getProcessVirtualWithChildrenMemory(Long processId) throws IOException, NoProcessFoundException {

        Set<Long> childrenProcesses = getChildrenTree(processId);

        Long value = 0L;
        for (Long ps : childrenProcesses) {
            value += getProcessVirtualMemory(ps).getKB();
        }

        return new Memory(value * 1024);
    }

    /**
     * Returns cpu time of process (in seconds)
     * @param processId Process id
     * @return Time in seconds
     * @throws IOException if can not get information from os
     */
    public Long getProcessCpuTime(Long processId) throws IOException {

        String result = CommandCaller.call("ps -o time " + processId);
        String[] lines = result.split("\n");
        System.out.println(lines[1].trim());
        String[] elements = lines[1].trim().split(":");
        int hours = Integer.valueOf(elements[0]);
        int minutes = Integer.valueOf(elements[1]);
        int seconds = Integer.valueOf(elements[2]);
        return hours * 3600L + minutes * 60L + seconds;
    }

    /**
     * Returns cpu time of a process (in seconds) and its all tree (recursively).
     * @param processId Process id
     * @return Time in seconds
     * @throws IOException if can not get information from os
     */
    public Long getProcessCpuTimeWithChildren(Long processId) throws IOException {

        Set<Long> childrenProcesses = getChildrenTree(processId);
        Long totalTime = 0L;
        for (Long childrenProcess : childrenProcesses) {
            totalTime += getProcessCpuTime(childrenProcess);
        }

        return totalTime;
    }

}

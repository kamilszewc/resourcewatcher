package io.github.kamilszewc.resourcewatcher.watchers.linux;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.core.CommandCaller;
import io.github.kamilszewc.resourcewatcher.exceptions.NoProcessFoundException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.ProcessWatcher;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ProcessWatcher class - Linux specialization
 */
public class ProcessWatcherLinux implements ProcessWatcher {

    private Long getSmapValue(Long processId, String key) throws IOException {

        String result = CommandCaller.call("cat /proc/" + processId + "/smaps");
        List<String> lines = Arrays.stream(result.split("\n")).collect(Collectors.toList());
        List<Long> values = lines.stream()
                .filter(entry -> entry.contains(key))
                .map(entry -> entry.split(":")[1].strip())
                .map(entry -> entry.split(" ")[0])
                .map(entry -> Long.valueOf(entry))
                .collect(Collectors.toList());

        return values.stream().reduce(0l, Long::sum);
    }

    /**
     * Returns information about process Proportional Set Size (PSS) memory.
     * @param processId Process id
     * @return Memory object
     * @throws IOException if can not get information from os
     */
    public Memory getProcessProportionalSetSizeMemory(Long processId) throws IOException {

        Long value = getSmapValue(processId, "Pss");

        return new Memory(value * 1024);
    }

    /**
     * Returns information about Proportional Set Size (PPS) memory of a process and its all tree (recursively).
     * @param processId Process id
     * @return Memory object
     * @throws IOException if can not get information from os
     * @throws NoProcessFoundException if no process found
     */
    public Memory getProcessProportionalSetSizeWithChildrenMemory(Long processId) throws IOException, NoProcessFoundException {
        Set<Long> childrenProcesses = getChildrenTree(processId);

        Long value = 0L;
        for (Long ps : childrenProcesses) {
            value += getProcessProportionalSetSizeMemory(ps).getKB();
        }

        return new Memory(value * 1024);
    }

    /**
     * Returns information about process Unique Set Size (USS) memory.
     * @param processId Process id
     * @return Memory object
     * @throws IOException if can not get information from os
     * @throws NoProcessFoundException if no process found
     */
    public Memory getProcessUniqueSetSizeMemory(Long processId) throws IOException, NoProcessFoundException {
        Long valuePrivateClean = getSmapValue(processId, "Private_Clean");
        Long valuePrivateDirty = getSmapValue(processId, "Private_Dirty");
        Long value = valuePrivateClean + valuePrivateDirty;

        return new Memory(value * 1024);
    }

    /**
     * Returns information about Unique Set Size (USS) memory of a process and its all tree (recursively).
     * @param processId Process id
     * @return Memory object
     * @throws IOException if can not get information from os
     * @throws NoProcessFoundException if no process found
     */
    public Memory getProcessUniqueSetSizeWithChildrenMemory(Long processId) throws IOException, NoProcessFoundException {
        Set<Long> childrenProcesses = getChildrenTree(processId);

        Long value = 0L;
        for (Long ps : childrenProcesses) {
            value += getProcessUniqueSetSizeMemory(ps).getKB();
        }

        return new Memory(value * 1024);
    }


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

package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.exceptions.NoProcessFoundException;

import java.io.IOException;
import java.util.Set;

/**
 * The class allows to get an information about the specific processes in the system.
 */
public interface ProcessWatcher {

    /**
     * Returns information about process Resident Set Size (RSS) memory.
     * @param processId Process id
     * @return Memory object
     * @throws IOException if can not get information from os
     * @throws NoProcessFoundException if no process found
     */
    Memory getProcessResidentSetSizeMemory(Long processId) throws IOException, NoProcessFoundException;

    /**
     * Returns information about process Virtual Memory.
     * @param processId Process id
     * @return Memory object
     * @throws IOException if can not get information from os
     * @throws NoProcessFoundException if no process found
     */
    Memory getProcessVirtualMemory(Long processId) throws IOException, NoProcessFoundException;

    /**
     * Returns a set of children processes for given parent process (recursively)
     * @param processId Process id
     * @return Set of process ids
     * @throws IOException if can not get information from os
     * @throws NoProcessFoundException if no process found
     */
    Set<Long> getChildrenTree(final Long processId) throws IOException, NoProcessFoundException;

    /**
     * Returns information about Resident Set Size (RSS) memory of a process and its all children (recursively).
     * @param processId Process id
     * @return Memory object
     * @throws IOException if can not get information from os
     * @throws NoProcessFoundException if no process found
     */
    Memory getProcessResidentSetSizeWithChildrenMemory(Long processId) throws IOException, NoProcessFoundException;

    /**
     * Returns information about Virtual Memory of a process and its all tree (recursively).
     * @param processId Process id
     * @return Memory object
     * @throws IOException if can not get information from os
     * @throws NoProcessFoundException if no process found
     */
    Memory getProcessVirtualWithChildrenMemory(Long processId) throws IOException, NoProcessFoundException;

}

package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.exceptions.NoProcessFoundException;

import java.io.IOError;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

/**
 * The class allows to get an information about the specific processes in the system.
 */
public interface ProcessWatcher {

    /**
     * Returns information about process Proportional Set Size (PSS) memory.
     * @param processId Process id
     * @return Memory object
     * @throws IOError
     * @throws IOException
     * @throws NoProcessFoundException
     */
    Memory getProcessProportionalSetSizeMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    /**
     * Returns information about Proportional Set Size (PPS) memory of a process and its all tree (recursively).
     * @param processId Process id
     * @return Memory object
     * @throws IOError
     * @throws IOException
     * @throws NoProcessFoundException
     */
    Memory getProcessProportionalSetSizeWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    /**
     * Returns information about process Unique Set Size (USS) memory.
     * @param processId Process id
     * @return Memory object
     * @throws IOError
     * @throws IOException
     * @throws NoProcessFoundException
     */
    Memory getProcessUniqueSetSizeMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    /**
     * Returns information about Unique Set Size (USS) memory of a process and its all tree (recursively).
     * @param processId Process id
     * @return Memory object
     * @throws IOError
     * @throws IOException
     * @throws NoProcessFoundException
     */
    Memory getProcessUniqueSetSizeWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException;


    /**
     * Returns information about process Resident Set Size (RSS) memory.
     * @param processId Process id
     * @return Memory object
     * @throws IOError
     * @throws IOException
     * @throws NoProcessFoundException
     */
    Memory getProcessResidentSetSizeMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    /**
     * Returns information about process Virtual Memory.
     * @param processId Process id
     * @return Memory object
     * @throws IOError
     * @throws IOException
     * @throws NoProcessFoundException
     */
    Memory getProcessVirtualMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    /**
     * Returns a set of children processes for given parent process (recursively)
     * @param processId Process id
     * @return Set of process ids
     * @throws IOError
     * @throws IOException
     * @throws NoProcessFoundException
     */
    Set<Long> getChildrenTree(final Long processId) throws IOError, IOException, NoProcessFoundException;

    /**
     * Returns information about Resident Set Size (RSS) memory of a process and its all children (recursively).
     * @param processId Process id
     * @return Memory object
     * @throws IOError
     * @throws IOException
     * @throws NoProcessFoundException
     */
    Memory getProcessResidentSetSizeWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    /**
     * Returns information about Virtual Memory of a process and its all tree (recursively).
     * @param processId Process id
     * @return Memory object
     * @throws IOError
     * @throws IOException
     * @throws NoProcessFoundException
     */
    Memory getProcessVirtualWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    /**
     * Returns cpu time of process (in seconds)
     * @param processId Process id
     * @return Time in seconds
     * @throws IOError
     * @throws IOException
     * @throws NoProcessFoundException
     */
    Long getProcessCpuTime(Long processId) throws IOError, IOException, NoProcessFoundException;

    /**
     * Returns cpu time of a process (in seconds) and its all tree (recursively).
     * @param processId Process id
     * @return Time in seconds
     * @throws IOError
     * @throws IOException
     * @throws NoProcessFoundException
     */
    Long getProcessCpuTimeWithChildren(Long processId) throws IOError, IOException, NoProcessFoundException;
}

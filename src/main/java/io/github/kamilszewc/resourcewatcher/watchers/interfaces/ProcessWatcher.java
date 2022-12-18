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

    Memory getProcessProportionalSetSizeMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    Memory getProcessProportionalSetSizeWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    Memory getProcessUniqueSetSizeMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    Memory getProcessUniqueSetSizeWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException;


    Memory getProcessResidentSetSizeMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    Memory getProcessVirtualMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    Set<Long> getChildrenTree(final Long processId) throws IOError, IOException, NoProcessFoundException;

    Memory getProcessResidentSetSizeWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    Memory getProcessVirtualWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    Long getProcessCpuTime(Long processId) throws IOError, IOException, NoProcessFoundException;

    Long getProcessCpuTimeWithChildren(Long processId) throws IOError, IOException, NoProcessFoundException;
}

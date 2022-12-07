package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.exceptions.NoProcessFoundException;

import java.io.IOError;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public interface ProcessWatcher {
    Memory getProcessResidentSetSizeMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    Memory getProcessVirtualMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    Set<Long> getChildrenTree(final Long processId) throws IOError, IOException, NoProcessFoundException;

    Memory getProcessResidentSetSizeWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    Memory getProcessVirtualWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException;

    Duration getProcessCpuTime(Long processId) throws IOError, IOException, NoProcessFoundException;

    Duration getProcessCpuTimeWithChildren(Long processId) throws IOError, IOException, NoProcessFoundException;
}

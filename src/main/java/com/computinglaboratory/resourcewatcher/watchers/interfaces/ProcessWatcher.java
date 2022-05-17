package com.computinglaboratory.resourcewatcher.watchers.interfaces;

import com.computinglaboratory.resourcewatcher.core.Memory;

import java.io.IOError;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public interface ProcessWatcher {
    public abstract Memory getProcessResidentSetSizeMemory(Long processId) throws IOError, IOException;

    public abstract Memory getProcessVirtualMemory(Long processId) throws IOError, IOException;

    public abstract Set<Long> getChildrenTree(final Long processId) throws IOError, IOException;

    public abstract Memory getProcessResidentSetSizeWithChildrenMemory(Long processId) throws IOError, IOException;

    public abstract Memory getProcessVirtualWithChildrenMemory(Long processId) throws IOError, IOException;

    public abstract Duration getProcessCpuTime(Long processId) throws IOError, IOException;

    public abstract Duration getProcessCpuTimeWithChildren(Long processId) throws IOError, IOException;
}

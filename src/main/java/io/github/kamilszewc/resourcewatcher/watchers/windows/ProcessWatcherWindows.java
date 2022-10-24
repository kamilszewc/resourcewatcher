package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.ProcessWatcher;

import java.io.IOError;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class ProcessWatcherWindows implements ProcessWatcher {
    @Override
    public Memory getProcessResidentSetSizeMemory(Long processId) throws IOError, IOException {
        return null;
    }

    @Override
    public Memory getProcessVirtualMemory(Long processId) throws IOError, IOException {
        return null;
    }

    @Override
    public Set<Long> getChildrenTree(Long processId) throws IOError {
        return null;
    }

    @Override
    public Memory getProcessResidentSetSizeWithChildrenMemory(Long processId) throws IOError {
        return null;
    }

    @Override
    public Memory getProcessVirtualWithChildrenMemory(Long processId) throws IOError {
        return null;
    }

    @Override
    public Duration getProcessCpuTime(Long processId) throws IOError {
        return null;
    }

    @Override
    public Duration getProcessCpuTimeWithChildren(Long processId) throws IOError {
        return null;
    }

}

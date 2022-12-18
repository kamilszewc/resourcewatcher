package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.exceptions.NoProcessFoundException;
import io.github.kamilszewc.resourcewatcher.exceptions.NotImplementedException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.ProcessWatcher;

import java.io.IOError;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class ProcessWatcherWindows implements ProcessWatcher {

    @Override
    public Memory getProcessProportionalSetSizeMemory(Long processId) throws IOError, IOException, NoProcessFoundException {
        throw new NotImplementedException();
    }

    @Override
    public Memory getProcessProportionalSetSizeWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException {
        throw new NotImplementedException();
    }

    @Override
    public Memory getProcessUniqueSetSizeMemory(Long processId) throws IOError, IOException, NoProcessFoundException {
        throw new NotImplementedException();
    }

    @Override
    public Memory getProcessUniqueSetSizeWithChildrenMemory(Long processId) throws IOError, IOException, NoProcessFoundException {
        throw new NotImplementedException();
    }

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
    public Long getProcessCpuTime(Long processId) throws IOError {
        return null;
    }

    @Override
    public Long getProcessCpuTimeWithChildren(Long processId) throws IOError {
        return null;
    }

}

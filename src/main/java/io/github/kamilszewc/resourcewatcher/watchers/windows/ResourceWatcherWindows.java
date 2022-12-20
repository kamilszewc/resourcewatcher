package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.exceptions.NotImplementedException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.*;
import io.github.kamilszewc.resourcewatcher.watchers.universal.DiskWatcherUniversal;

public class ResourceWatcherWindows implements ResourceWatcher {

    @Override
    public CpuWatcher getCpuWatcher() {
        return new CpuWatcherWindows();
    }

    @Override
    public DiskWatcher getDiskWatcher() {
        return new DiskWatcherUniversal();
    }

    @Override
    public NetworkWatcher getNetworkWatcher() {
        throw new NotImplementedException();
    }

    @Override
    public NvidiaCudaWatcher getNvidiaCudaWatcher() {
        throw new NotImplementedException();
    }

    @Override
    public ProcessWatcher getProcessWatcher() {
        throw new NotImplementedException();
    }

    @Override
    public RamWatcher getRamWatcher() {
        throw new NotImplementedException();
    }

    @Override
    public SystemWatcher getSystemWatcher() {
        throw new NotImplementedException();
    }
}

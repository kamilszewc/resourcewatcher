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
        return new NetworkWatcherWindows();
    }

    @Override
    public NvidiaCudaWatcher getNvidiaCudaWatcher() {
        throw new NotImplementedException();
    }

    @Override
    public ProcessWatcher getProcessWatcher() {
        return new ProcessWatcherWindows();
    }

    @Override
    public RamWatcher getRamWatcher() {
        return new RamWatcherWindows();
    }

    @Override
    public SystemWatcher getSystemWatcher() {
        return new SystemWatcherWindows();
    }
}

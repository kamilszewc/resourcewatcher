package com.computinglaboratory.resourcewatcher.watchers.linux;

import com.computinglaboratory.resourcewatcher.watchers.interfaces.*;

public class ResourceWatcherLinux implements ResourceWatcher {

    @Override
    public DiskWatcher getDiskWatcher() {
        return new DiskWatcherLinux();
    }

    @Override
    public NetworkWatcher getNetworkWatcher() {
        return new NetworkWatcherLinux();
    }

    @Override
    public NvidiaCudaWatcher getNvidiaCudaWatcher() {
        return new NvidiaCudaWatcherLinux();
    }

    @Override
    public ProcessWatcher getProcessWatcher() {
        return new ProcessWatcherLinux();
    }

    @Override
    public RamWatcher getRamWatcher() {
        return new RamWatcherLinux();
    }

    @Override
    public SystemProcessesWatcher getSystemProcessesWatcher() {
        return new SystemProcessesWatcherLinux();
    }
}

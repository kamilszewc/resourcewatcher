package com.computinglaboratory.resourcewatcher.watchers.linux;

import com.computinglaboratory.resourcewatcher.watchers.interfaces.*;
import com.computinglaboratory.resourcewatcher.watchers.universal.DiskWatcherUniversal;

public class ResourceWatcherLinux implements ResourceWatcher {

    @Override
    public DiskWatcher getDiskWatcher() {
        return new DiskWatcherUniversal();
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

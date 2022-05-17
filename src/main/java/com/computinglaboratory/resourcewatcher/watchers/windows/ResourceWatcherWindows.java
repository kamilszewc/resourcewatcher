package com.computinglaboratory.resourcewatcher.watchers.windows;

import com.computinglaboratory.resourcewatcher.watchers.interfaces.*;
import com.computinglaboratory.resourcewatcher.watchers.universal.DiskWatcherUniversal;

public class ResourceWatcherWindows implements ResourceWatcher {

    @Override
    public DiskWatcher getDiskWatcher() {
        return new DiskWatcherUniversal();
    }

    @Override
    public NetworkWatcher getNetworkWatcher() {
        return null;
    }

    @Override
    public NvidiaCudaWatcher getNvidiaCudaWatcher() {
        return null;
    }

    @Override
    public ProcessWatcher getProcessWatcher() {
        return null;
    }

    @Override
    public RamWatcher getRamWatcher() {
        return null;
    }

    @Override
    public SystemProcessesWatcher getSystemProcessesWatcher() {
        return null;
    }
}

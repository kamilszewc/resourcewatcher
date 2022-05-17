package com.computinglaboratory.resourcewatcher.watchers.macos;

import com.computinglaboratory.resourcewatcher.watchers.interfaces.*;
import com.computinglaboratory.resourcewatcher.watchers.universal.DiskWatcherUniversal;

public class ResourceWatcherMac implements ResourceWatcher {

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
        return new ProcessWatcherMac();
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

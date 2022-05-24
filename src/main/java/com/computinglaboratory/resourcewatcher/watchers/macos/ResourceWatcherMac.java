package com.computinglaboratory.resourcewatcher.watchers.macos;

import com.computinglaboratory.resourcewatcher.exceptions.NotImplementedException;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.*;
import com.computinglaboratory.resourcewatcher.watchers.linux.RamWatcherLinux;
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
        throw new NotImplementedException();
    }

    @Override
    public ProcessWatcher getProcessWatcher() {
        return new ProcessWatcherMac();
    }

    @Override
    public RamWatcher getRamWatcher() {
        return new RamWatcherMac();
    }

    @Override
    public SystemProcessesWatcher getSystemProcessesWatcher() {
        return new SystemProcessesWatcherMac();
    }
}

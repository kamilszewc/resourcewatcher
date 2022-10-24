package io.github.kamilszewc.resourcewatcher.watchers.macos;

import io.github.kamilszewc.resourcewatcher.exceptions.NotImplementedException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.*;
import io.github.kamilszewc.resourcewatcher.watchers.universal.DiskWatcherUniversal;

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

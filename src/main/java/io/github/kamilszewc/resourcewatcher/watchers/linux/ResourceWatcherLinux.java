package io.github.kamilszewc.resourcewatcher.watchers.linux;

import io.github.kamilszewc.resourcewatcher.watchers.interfaces.*;
import io.github.kamilszewc.resourcewatcher.watchers.universal.DiskWatcherUniversal;

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

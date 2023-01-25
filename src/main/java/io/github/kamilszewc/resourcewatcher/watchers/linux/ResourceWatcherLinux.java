package io.github.kamilszewc.resourcewatcher.watchers.linux;

import io.github.kamilszewc.resourcewatcher.watchers.interfaces.*;
import io.github.kamilszewc.resourcewatcher.watchers.universal.DiskWatcherUniversal;

/**
 * ResourceWatcher class - Linux specialization
 */
public class ResourceWatcherLinux implements ResourceWatcher {

    /**
     * Constructor
     */
    public ResourceWatcherLinux() {}

    @Override
    public CpuWatcher getCpuWatcher() {
        return new CpuWatcherLinux();
    }

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
    public SystemWatcher getSystemWatcher() {
        return new SystemWatcherLinux();
    }
}

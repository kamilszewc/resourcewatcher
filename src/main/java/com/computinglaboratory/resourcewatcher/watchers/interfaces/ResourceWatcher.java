package com.computinglaboratory.resourcewatcher.watchers.interfaces;

public interface ResourceWatcher {
    public abstract DiskWatcher getDiskWatcher();

    public abstract NetworkWatcher getNetworkWatcher();

    public abstract NvidiaCudaWatcher getNvidiaCudaWatcher();

    public abstract ProcessWatcher getProcessWatcher();

    public abstract RamWatcher getRamWatcher();

    public abstract SystemProcessesWatcher getSystemProcessesWatcher();
}

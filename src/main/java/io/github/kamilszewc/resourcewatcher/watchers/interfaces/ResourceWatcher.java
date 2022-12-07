package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.exceptions.NotImplementedException;

public interface ResourceWatcher {

    CpuWatcher getCpuWatcher();

    DiskWatcher getDiskWatcher();

    NetworkWatcher getNetworkWatcher();

    NvidiaCudaWatcher getNvidiaCudaWatcher() throws NotImplementedException;

    ProcessWatcher getProcessWatcher();

    RamWatcher getRamWatcher();

    SystemProcessesWatcher getSystemProcessesWatcher();
}

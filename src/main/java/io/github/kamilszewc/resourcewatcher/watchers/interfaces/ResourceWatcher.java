package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.exceptions.NotImplementedException;

/**
 * The class allows to get different types of resource watchers.
 */
public interface ResourceWatcher {

    CpuWatcher getCpuWatcher();

    DiskWatcher getDiskWatcher();

    NetworkWatcher getNetworkWatcher();

    NvidiaCudaWatcher getNvidiaCudaWatcher() throws NotImplementedException;

    ProcessWatcher getProcessWatcher();

    RamWatcher getRamWatcher();

    SystemProcessesWatcher getSystemProcessesWatcher();
}

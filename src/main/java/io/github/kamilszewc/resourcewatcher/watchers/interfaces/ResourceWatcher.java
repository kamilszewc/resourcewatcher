package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.exceptions.NotImplementedException;

/**
 * The class allows to get different types of resource watchers.
 */
public interface ResourceWatcher {

    /**
     * Returns the CpuWatcher object
     * @return CpuWatcher object
     */
    CpuWatcher getCpuWatcher();

    /**
     * Returns the DiskWatcher object
     * @return DiskWatcher object
     */
    DiskWatcher getDiskWatcher();

    /**
     * Returns the NetworkWatcher object
     * @return NetworkWatcher object
     */
    NetworkWatcher getNetworkWatcher();

    /**
     * Returns the NetworkWatcher object
     * @return NetworkWatcher object
     * @throws NotImplementedException
     */
    NvidiaCudaWatcher getNvidiaCudaWatcher() throws NotImplementedException;

    /**
     * Returns the ProcessWatcher object
     * @return ProcessWatcher object
     */
    ProcessWatcher getProcessWatcher();

    /**
     * Returns the RamWatcher object
     * @return RamWatcher object
     */
    RamWatcher getRamWatcher();

    /**
     * Returns the SystemProcessesWatcher object
     * @return SystemProcessesWatcher object
     */
    SystemProcessesWatcher getSystemProcessesWatcher();
}

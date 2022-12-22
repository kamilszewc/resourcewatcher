package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory;
import io.github.kamilszewc.resourcewatcher.exceptions.NotImplementedException;
import io.github.kamilszewc.resourcewatcher.exceptions.UnknownOperatingSystemException;

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
     * @throws NotImplementedException if the method is not implemented
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
    SystemWatcher getSystemWatcher();

    /**
     * Automatically detects the OS and produces the right ResourceWatcher object
     * @return ResourceWatcher object for detected OS
     * @throws UnknownOperatingSystemException if operating system is unknown
     */
     static ResourceWatcher create() throws UnknownOperatingSystemException {
        return ResourceWatcherFactory.create();
    }
}

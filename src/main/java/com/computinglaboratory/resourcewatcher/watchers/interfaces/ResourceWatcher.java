package com.computinglaboratory.resourcewatcher.watchers.interfaces;

import com.computinglaboratory.resourcewatcher.ResourceWatcherFactory;
import com.computinglaboratory.resourcewatcher.exceptions.NotImplementedException;
import com.computinglaboratory.resourcewatcher.exceptions.UnknownOperatingSystemException;
import org.apache.commons.lang3.SystemUtils;

/**
 * The class allows to get different types of resource watchers.
 */
public interface ResourceWatcher {

    /**
     * Describes the Operating System type
     */
    enum OperatingSystem {WINDOWS, LINUX, MACOS, UNKNOWN};

    /**
     * Returns the type of operating system
     * @return OperatingSystem object
     */
    static OperatingSystem getOperatingSystem() {
        if (SystemUtils.IS_OS_LINUX) {
            return OperatingSystem.LINUX;

        } else if (SystemUtils.IS_OS_MAC) {
            return OperatingSystem.MACOS;

        } else if (SystemUtils.IS_OS_WINDOWS) {
            return OperatingSystem.WINDOWS;

        } else {
            return OperatingSystem.UNKNOWN;
        }
    }

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

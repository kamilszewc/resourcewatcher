package com.computinglaboratory.resourcewatcher.watchers.interfaces;

import com.computinglaboratory.resourcewatcher.core.Memory;

import java.io.IOException;

/**
 * The class allows to get an information about RAM memory in the system.
 */
public interface RamWatcher {

    /**
     * Get the total memory in the OS
     * @return total memory
     * @throws IOException if can not get information from os
     */
    Memory getTotalMemory() throws IOException;

    /**
     * Get the free memory in the OS
     * @return free memory
     * @throws IOException if can not get information from os
     */
    Memory getFreeMemory() throws IOException;

    /**
     * Get the available memory in the OS
     * @return available memory
     * @throws IOException if can not get information from os
     */
    Memory getAvailableMemory() throws IOException;
}

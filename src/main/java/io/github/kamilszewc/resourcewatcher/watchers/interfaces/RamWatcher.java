package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.core.Memory;

import java.io.IOError;
import java.io.IOException;

/**
 * The class allows to get an information about RAM memory in the system.
 */
public interface RamWatcher {

    /**
     * Get the total memory in the OS
     * @return total memory
     * @throws IOError
     * @throws IOException
     */
    Memory getTotalMemory() throws IOError, IOException;

    /**
     * Get the free memory in the OS
     * @return free memory
     * @throws IOError
     * @throws IOException
     */
    Memory getFreeMemory() throws IOError, IOException;

    /**
     * Get the available memory in the OS
     * @return available memory
     * @throws IOError
     * @throws IOException
     */
    Memory getAvailableMemory() throws IOError, IOException;
}

package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.core.CpuInfo;

import java.io.IOException;

/**
 * The class allows to get an information about the CPU in the system.
 */
public interface CpuWatcher {

    /**
     * Get information about CPU
     * @return CpuInfo object
     * @throws IOException
     */
    CpuInfo getCpuInfo() throws IOException;
}

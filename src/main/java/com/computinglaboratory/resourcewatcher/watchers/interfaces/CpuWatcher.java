package com.computinglaboratory.resourcewatcher.watchers.interfaces;

import com.computinglaboratory.resourcewatcher.core.CpuInfo;

import java.io.IOException;

/**
 * The class allows to get an information about the CPU in the system.
 */
public interface CpuWatcher {

    /**
     * Get information about CPU
     * @return CpuInfo object
     * @throws IOException if can not get information from os
     */
    CpuInfo getCpuInfo() throws IOException;
}

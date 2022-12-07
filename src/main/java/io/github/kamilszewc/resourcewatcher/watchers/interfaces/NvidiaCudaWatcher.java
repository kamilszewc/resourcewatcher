package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.core.Memory;

import java.io.IOError;
import java.io.IOException;

/**
 * The class allows to get an information about the NVIDIA CUDA in the system.
 */
public interface NvidiaCudaWatcher {

    Memory getUsedMemory(Integer gpuId) throws IOError, IOException;

    Integer getNumberOfGpus() throws IOError, IOException;

    Memory getFreeMemory(Integer gpuId) throws IOError, IOException;

    Memory getTotalMemory(Integer gpuId) throws IOError, IOException;

    Integer getTemperature(Integer gpuId) throws IOError, IOException;

    Integer getUtilization(Integer gpuId) throws IOError, IOException;

    String getName(Integer gpuId) throws IOError, IOException;
}

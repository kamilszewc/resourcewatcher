package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.core.Memory;

import java.io.IOError;
import java.io.IOException;

/**
 * The class allows to get an information about the NVIDIA CUDA in the system.
 */
public interface NvidiaCudaWatcher {

    /**
     * Get memory used in the specific gpu
     * @param gpuId the id of the gpu
     * @return used memory
     * @throws IOError
     * @throws IOException
     */
    Memory getUsedMemory(Integer gpuId) throws IOError, IOException;

    /**
     * Get number of gpus avilable in the system
     * @return number of gpus
     * @throws IOError
     * @throws IOException
     */
    Integer getNumberOfGpus() throws IOError, IOException;

    /**
     * Get available (free) in the specific gpu
     * @param gpuId the id of the gpu
     * @return free memory
     * @throws IOError
     * @throws IOException
     */
    Memory getFreeMemory(Integer gpuId) throws IOError, IOException;

    /**
     * Get total memory of the specific gpu
     * @param gpuId the id of the gpu
     * @return total memory
     * @throws IOError
     * @throws IOException
     */
    Memory getTotalMemory(Integer gpuId) throws IOError, IOException;

    /**
     * Get temperature of the specific gpu
     * @param gpuId the id of the gpu
     * @return temperature
     * @throws IOError
     * @throws IOException
     */
    Integer getTemperature(Integer gpuId) throws IOError, IOException;

    /**
     * Get utilisation of the specific gpu
     * @param gpuId the id of the gpu
     * @return utilisation (%)
     * @throws IOError
     * @throws IOException
     */
    Integer getUtilization(Integer gpuId) throws IOError, IOException;

    /**
     * Get name of the specific gpu
     * @param gpuId the id of the gpu
     * @return name
     * @throws IOError
     * @throws IOException
     */
    String getName(Integer gpuId) throws IOError, IOException;
}

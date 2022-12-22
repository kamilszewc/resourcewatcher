package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.core.Memory;

import java.io.IOException;

/**
 * The class allows to get an information about the NVIDIA CUDA in the system.
 */
public interface NvidiaCudaWatcher {

    /**
     * Get memory used in the specific gpu
     * @param gpuId the id of the gpu
     * @return used memory
     * @throws IOException if can not get information from os
     */
    Memory getUsedMemory(Integer gpuId) throws IOException;

    /**
     * Get number of gpus avilable in the system
     * @return number of gpus
     * @throws IOException if can not get information from os
     */
    Integer getNumberOfGpus() throws IOException;

    /**
     * Get available (free) in the specific gpu
     * @param gpuId the id of the gpu
     * @return free memory
     * @throws IOException if can not get information from os
     */
    Memory getFreeMemory(Integer gpuId) throws IOException;

    /**
     * Get total memory of the specific gpu
     * @param gpuId the id of the gpu
     * @return total memory
     * @throws IOException if can not get information from os
     */
    Memory getTotalMemory(Integer gpuId) throws IOException;

    /**
     * Get temperature of the specific gpu
     * @param gpuId the id of the gpu
     * @return temperature
     * @throws IOException if can not get information from os
     */
    Integer getTemperature(Integer gpuId) throws IOException;

    /**
     * Get utilisation of the specific gpu
     * @param gpuId the id of the gpu
     * @return utilisation (%)
     * @throws IOException if can not get information from os
     */
    Integer getUtilization(Integer gpuId) throws IOException;

    /**
     * Get name of the specific gpu
     * @param gpuId the id of the gpu
     * @return name
     * @throws IOException if can not get information from os
     */
    String getName(Integer gpuId) throws IOException;
}

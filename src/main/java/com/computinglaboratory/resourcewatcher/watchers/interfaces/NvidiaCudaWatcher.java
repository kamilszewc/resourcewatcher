package com.computinglaboratory.resourcewatcher.watchers.interfaces;

import com.computinglaboratory.resourcewatcher.core.Memory;

import java.io.IOError;
import java.io.IOException;

public interface NvidiaCudaWatcher {
    public abstract Boolean isNvidiaSmiAvailable() throws IOError;

    public abstract Memory getUsedMemory(Integer gpuId) throws IOError, IOException;

    public abstract Integer getNumberOfGpus() throws IOError, IOException;

    public abstract Memory getFreeMemory(Integer gpuId) throws IOError, IOException;

    public abstract Memory getTotalMemory(Integer gpuId) throws IOError, IOException;

    public abstract Integer getTemperature(Integer gpuId) throws IOError, IOException;

    public abstract Integer getUtilization(Integer gpuId) throws IOError, IOException;

    public abstract String getName(Integer gpuId) throws IOError, IOException;
}

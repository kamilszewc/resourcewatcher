package com.computinglaboratory.resourcewatcher.watchers.windows;

import com.computinglaboratory.resourcewatcher.core.Memory;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.NvidiaCudaWatcher;

import java.io.IOError;

public class NvidiaCudaWatcherWindows implements NvidiaCudaWatcher {
    @Override
    public Boolean isNvidiaSmiAvailable() throws IOError {
        return null;
    }

    @Override
    public Memory getUsedMemory(Integer gpuId) throws IOError {
        return null;
    }

    @Override
    public Integer getNumberOfGpus() throws IOError {
        return null;
    }

    @Override
    public Memory getFreeMemory(Integer gpuId) throws IOError {
        return null;
    }

    @Override
    public Memory getTotalMemory(Integer gpuId) throws IOError {
        return null;
    }

    @Override
    public Integer getTemperature(Integer gpuId) throws IOError {
        return null;
    }

    @Override
    public Integer getUtilization(Integer gpuId) throws IOError {
        return null;
    }

    @Override
    public String getName(Integer gpuId) throws IOError {
        return null;
    }

}

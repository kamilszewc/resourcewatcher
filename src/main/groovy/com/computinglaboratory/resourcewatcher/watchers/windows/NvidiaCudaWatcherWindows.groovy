package com.computinglaboratory.resourcewatcher.watchers.windows

import com.computinglaboratory.resourcewatcher.core.Memory
import com.computinglaboratory.resourcewatcher.core.ProcessCommand
import com.computinglaboratory.resourcewatcher.core.Report
import com.computinglaboratory.resourcewatcher.watchers.interfaces.NvidiaCudaWatcher

class NvidiaCudaWatcherWindows implements NvidiaCudaWatcher {

    @Override
    Report<Boolean> isNvidiaSmiAvailable() throws IOError {
        try {
            def value = new ProcessCommand("nvidia-smi.exe").by {}
        } catch (IOException ex) {
            return new Report<>(false)
        }
        return new Report<>(true)
    }

    @Override
    Report<Memory> getUsedMemory(Integer gpuId) throws IOError {
        return null
    }

    @Override
    Report<Integer> getNumberOfGpus() throws IOError {
        return null
    }

    @Override
    Report<Memory> getFreeMemory(Integer gpuId) throws IOError {
        return null
    }

    @Override
    Report<Memory> getTotalMemory(Integer gpuId) throws IOError {
        return null
    }

    @Override
    Report<Integer> getTemperature(Integer gpuId) throws IOError {
        return null
    }

    @Override
    Report<Integer> getUtilization(Integer gpuId) throws IOError {
        return null
    }

    @Override
    Report<String> getName(Integer gpuId) throws IOError {
        return null
    }
}

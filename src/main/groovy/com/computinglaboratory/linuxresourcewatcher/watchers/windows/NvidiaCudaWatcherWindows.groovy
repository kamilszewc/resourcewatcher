package com.computinglaboratory.linuxresourcewatcher.watchers.windows

import com.computinglaboratory.linuxresourcewatcher.core.Memory
import com.computinglaboratory.linuxresourcewatcher.core.ProcessCommand
import com.computinglaboratory.linuxresourcewatcher.core.Report
import com.computinglaboratory.linuxresourcewatcher.watchers.NvidiaCudaWatcher

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
package com.computinglaboratory.resourcewatcher.watchers.interfaces

import com.computinglaboratory.resourcewatcher.core.*

interface NvidiaCudaWatcher {

    Report<Boolean> isNvidiaSmiAvailable() throws IOError

    Report<Memory> getUsedMemory(Integer gpuId) throws IOError

    Report<Integer> getNumberOfGpus() throws IOError

    Report<Memory> getFreeMemory(Integer gpuId) throws IOError

    Report<Memory> getTotalMemory(Integer gpuId) throws IOError

    Report<Integer> getTemperature(Integer gpuId) throws IOError

    Report<Integer> getUtilization(Integer gpuId) throws IOError

    Report<String> getName(Integer gpuId) throws IOError
}

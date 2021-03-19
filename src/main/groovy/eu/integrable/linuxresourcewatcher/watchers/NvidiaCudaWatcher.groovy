package eu.integrable.linuxresourcewatcher.watchers

import eu.integrable.linuxresourcewatcher.core.Memory
import eu.integrable.linuxresourcewatcher.core.Report

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

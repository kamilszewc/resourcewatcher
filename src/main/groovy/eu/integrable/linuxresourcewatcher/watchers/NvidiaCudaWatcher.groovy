package eu.integrable.linuxresourcewatcher.watchers

import eu.integrable.linuxresourcewatcher.core.Memory
import eu.integrable.linuxresourcewatcher.core.Report

interface NvidiaCudaWatcher {

    Report<Boolean> isNvidiaSmiAvailable()

    Report<Memory> getUsedMemory(Integer gpuId)

    Report<Integer> getNumberOfGpus()

    Report<Memory> getFreeMemory(Integer gpuId)

    Report<Memory> getTotalMemory(Integer gpuId)

    Report<Integer> getTemperature(Integer gpuId)

    Report<Integer> getUtilization(Integer gpuId)

    Report<String> getName(Integer gpuId)
}

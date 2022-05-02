package com.computinglaboratory.linuxresourcewatcher.watchers


import com.computinglaboratory.linuxresourcewatcher.core.Memory

interface NvidiaCudaWatcher {

    com.computinglaboratory.linuxresourcewatcher.core.Report<Boolean> isNvidiaSmiAvailable() throws IOError

    com.computinglaboratory.linuxresourcewatcher.core.Report<Memory> getUsedMemory(Integer gpuId) throws IOError

    com.computinglaboratory.linuxresourcewatcher.core.Report<Integer> getNumberOfGpus() throws IOError

    com.computinglaboratory.linuxresourcewatcher.core.Report<Memory> getFreeMemory(Integer gpuId) throws IOError

    com.computinglaboratory.linuxresourcewatcher.core.Report<Memory> getTotalMemory(Integer gpuId) throws IOError

    com.computinglaboratory.linuxresourcewatcher.core.Report<Integer> getTemperature(Integer gpuId) throws IOError

    com.computinglaboratory.linuxresourcewatcher.core.Report<Integer> getUtilization(Integer gpuId) throws IOError

    com.computinglaboratory.linuxresourcewatcher.core.Report<String> getName(Integer gpuId) throws IOError
}

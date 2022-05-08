package com.computinglaboratory.resourcewatcher.watchers.interfaces

interface ResourceWatcher {

    DiskWatcher getDiskWatcher()

    NetworkWatcher getNetworkWatcher()

    NvidiaCudaWatcher getNvidiaCudaWatcher()

    ProcessWatcher getProcessWatcher()

    RamWatcher getRamWatcher()

    SystemProcessesWatcher getSystemProcessesWatcher()
}

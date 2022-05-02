package com.computinglaboratory.linuxresourcewatcher.watchers.windows


import com.computinglaboratory.linuxresourcewatcher.core.Memory
import com.computinglaboratory.linuxresourcewatcher.core.Report
import com.computinglaboratory.linuxresourcewatcher.watchers.DiskWatcher

class DiskWatcherWindows implements DiskWatcher {

    @Override
    Report<Memory> getAvailablePartitionSpace(String partition) throws IOError, com.computinglaboratory.linuxresourcewatcher.exceptions.NoPartitionException {
        return null
    }

    @Override
    Report<Memory> getUsedPartitionSpace(String partition) throws IOError, com.computinglaboratory.linuxresourcewatcher.exceptions.NoPartitionException {
        return null
    }

    @Override
    Report<Memory> getListOfPartitions() throws IOError {
        return null
    }
}

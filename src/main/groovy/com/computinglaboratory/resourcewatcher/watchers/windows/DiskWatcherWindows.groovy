package com.computinglaboratory.resourcewatcher.watchers.windows


import com.computinglaboratory.resourcewatcher.core.Memory
import com.computinglaboratory.resourcewatcher.core.Report
import com.computinglaboratory.resourcewatcher.watchers.interfaces.DiskWatcher
import com.computinglaboratory.resourcewatcher.exceptions.NoPartitionException

class DiskWatcherWindows implements DiskWatcher {

    @Override
    Report<Memory> getAvailablePartitionSpace(String partition) throws IOError, NoPartitionException {
        return null
    }

    @Override
    Report<Memory> getUsedPartitionSpace(String partition) throws IOError, NoPartitionException {
        return null
    }

    @Override
    Report<Memory> getListOfPartitions() throws IOError {
        return null
    }
}

package com.computinglaboratory.resourcewatcher.watchers.interfaces


import com.computinglaboratory.resourcewatcher.core.Memory
import com.computinglaboratory.resourcewatcher.core.Report
import com.computinglaboratory.resourcewatcher.exceptions.NoPartitionException

interface DiskWatcher {

    Report<Memory> getAvailablePartitionSpace(String partition) throws IOError, NoPartitionException

    Report<Memory> getUsedPartitionSpace(String partition) throws IOError, NoPartitionException

    Report<Memory> getListOfPartitions() throws IOError
}

package com.computinglaboratory.linuxresourcewatcher.watchers


import com.computinglaboratory.linuxresourcewatcher.core.Memory
import com.computinglaboratory.linuxresourcewatcher.core.Report

interface DiskWatcher {

    Report<Memory> getAvailablePartitionSpace(String partition) throws IOError, com.computinglaboratory.linuxresourcewatcher.exceptions.NoPartitionException

    Report<Memory> getUsedPartitionSpace(String partition) throws IOError, com.computinglaboratory.linuxresourcewatcher.exceptions.NoPartitionException

    Report<Memory> getListOfPartitions() throws IOError
}

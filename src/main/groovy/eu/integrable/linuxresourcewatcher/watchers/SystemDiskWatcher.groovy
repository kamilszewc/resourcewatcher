package eu.integrable.linuxresourcewatcher.watchers

import eu.integrable.linuxresourcewatcher.core.Memory
import eu.integrable.linuxresourcewatcher.core.Report

interface SystemDiskWatcher {

    Report<Memory> getAvailablePartitionSpace(String partition)

    Report<Memory> getUsedPartitionSpace(String partition)

    Report<Memory> getListOfPartitions()
}

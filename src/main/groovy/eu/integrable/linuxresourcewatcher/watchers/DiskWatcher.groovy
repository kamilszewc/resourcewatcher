package eu.integrable.linuxresourcewatcher.watchers

import eu.integrable.linuxresourcewatcher.core.Memory
import eu.integrable.linuxresourcewatcher.core.Report
import eu.integrable.linuxresourcewatcher.exceptions.NoPartitionException

interface DiskWatcher {

    Report<Memory> getAvailablePartitionSpace(String partition) throws IOError, NoPartitionException

    Report<Memory> getUsedPartitionSpace(String partition) throws IOError, NoPartitionException

    Report<Memory> getListOfPartitions() throws IOError
}

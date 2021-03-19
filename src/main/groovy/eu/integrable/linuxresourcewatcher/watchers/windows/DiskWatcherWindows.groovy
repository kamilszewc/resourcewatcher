package eu.integrable.linuxresourcewatcher.watchers.windows

import eu.integrable.linuxresourcewatcher.core.Memory
import eu.integrable.linuxresourcewatcher.core.Report
import eu.integrable.linuxresourcewatcher.exceptions.NoPartitionException
import eu.integrable.linuxresourcewatcher.watchers.DiskWatcher

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

package eu.integrable.linuxresourcewatcher.watchers.windows

import eu.integrable.linuxresourcewatcher.core.Memory
import eu.integrable.linuxresourcewatcher.core.ProcessCommand
import eu.integrable.linuxresourcewatcher.core.Report
import eu.integrable.linuxresourcewatcher.exceptions.NoPartitionException
import eu.integrable.linuxresourcewatcher.watchers.SystemDiskWatcher

class SystemDiskWatcherWindows implements SystemDiskWatcher {

    @Override
    Report<Memory> getAvailablePartitionSpace(String partition) {
        return null
    }

    @Override
    Report<Memory> getUsedPartitionSpace(String partition) {
        return null
    }

    @Override
    Report<Memory> getListOfPartitions() {
        return null
    }
}

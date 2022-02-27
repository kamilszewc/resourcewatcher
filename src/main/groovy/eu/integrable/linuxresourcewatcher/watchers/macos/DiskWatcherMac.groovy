package eu.integrable.linuxresourcewatcher.watchers.macos

import eu.integrable.linuxresourcewatcher.core.Memory
import eu.integrable.linuxresourcewatcher.core.ProcessCommand
import eu.integrable.linuxresourcewatcher.core.Report
import eu.integrable.linuxresourcewatcher.exceptions.NoPartitionException
import eu.integrable.linuxresourcewatcher.watchers.DiskWatcher

class DiskWatcherMac implements DiskWatcher {

    @Override
    Report<Memory> getAvailablePartitionSpace(String partition) throws IOError, NoPartitionException {
        def value = new ProcessCommand("df $partition").by {
            try {
                it.split("\n")[1].trim().replaceAll(" +", " ").split(" ")[3] as Long
            } catch(Exception ex) {
                throw new NoPartitionException()
            }
        }
        return new Report<>(new Memory(value))
    }

    @Override
    Report<Memory> getUsedPartitionSpace(String partition) throws IOError, NoPartitionException {
        def value = new ProcessCommand("df $partition").by {
            try {
                it.split("\n")[1].trim().replaceAll(" +", " ").split(" ")[2] as Long
            } catch(Exception ex) {
                throw new NoPartitionException()
            }
        }
        return new Report<>(new Memory(value))
    }

    @Override
    Report<Memory> getListOfPartitions() throws IOError {
        def value = new ProcessCommand("df").by {
            def partitions = [] as List
            def lines = it.split("\n")
            for (int i=1; i<lines.size(); i++) {
                partitions << lines[i].trim().replaceAll(" +", " ").split(" ")[-1]
            }
            partitions
        }
        return new Report<>(value)
    }
}

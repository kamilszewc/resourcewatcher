package eu.integrable.linuxresourcewatcher.watchers

import eu.integrable.linuxresourcewatcher.core.Memory
import eu.integrable.linuxresourcewatcher.core.ProcessCommand
import eu.integrable.linuxresourcewatcher.core.Report
import eu.integrable.linuxresourcewatcher.exceptions.NoPartitionException

class SystemDiskWatcher {

    Report<Memory> getAvailablePartitionSpace(String partition) {
        def value = new ProcessCommand("df $partition").by {
            try {
                it.split("\n")[1].trim().replaceAll(" +", " ").split(" ")[-3] as Long
            } catch(Exception ex) {
                throw new NoPartitionException()
            }
        }
        return new Report<>(new Memory(value))
    }

    Report<Memory> getUsedPartitionSpace(String partition) {
        def value = new ProcessCommand("df $partition").by {
            try {
                it.split("\n")[1].trim().replaceAll(" +", " ").split(" ")[-4] as Long
            } catch(Exception ex) {
                throw new NoPartitionException()
            }
        }
        return new Report<>(new Memory(value))
    }

    Report<Memory> getListOfPartitions() {
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

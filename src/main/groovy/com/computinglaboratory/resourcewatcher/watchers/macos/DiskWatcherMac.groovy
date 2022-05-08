package com.computinglaboratory.resourcewatcher.watchers.macos


import com.computinglaboratory.resourcewatcher.core.Memory
import com.computinglaboratory.resourcewatcher.core.ProcessCommand
import com.computinglaboratory.resourcewatcher.core.Report
import com.computinglaboratory.resourcewatcher.watchers.interfaces.DiskWatcher
import com.computinglaboratory.resourcewatcher.exceptions.NoPartitionException

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

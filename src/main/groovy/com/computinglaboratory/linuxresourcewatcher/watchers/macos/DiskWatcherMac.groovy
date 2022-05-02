package com.computinglaboratory.linuxresourcewatcher.watchers.macos


import com.computinglaboratory.linuxresourcewatcher.core.Memory
import com.computinglaboratory.linuxresourcewatcher.core.ProcessCommand
import com.computinglaboratory.linuxresourcewatcher.core.Report
import com.computinglaboratory.linuxresourcewatcher.watchers.DiskWatcher

class DiskWatcherMac implements DiskWatcher {

    @Override
    Report<Memory> getAvailablePartitionSpace(String partition) throws IOError, com.computinglaboratory.linuxresourcewatcher.exceptions.NoPartitionException {
        def value = new ProcessCommand("df $partition").by {
            try {
                it.split("\n")[1].trim().replaceAll(" +", " ").split(" ")[3] as Long
            } catch(Exception ex) {
                throw new com.computinglaboratory.linuxresourcewatcher.exceptions.NoPartitionException()
            }
        }
        return new Report<>(new Memory(value))
    }

    @Override
    Report<Memory> getUsedPartitionSpace(String partition) throws IOError, com.computinglaboratory.linuxresourcewatcher.exceptions.NoPartitionException {
        def value = new ProcessCommand("df $partition").by {
            try {
                it.split("\n")[1].trim().replaceAll(" +", " ").split(" ")[2] as Long
            } catch(Exception ex) {
                throw new com.computinglaboratory.linuxresourcewatcher.exceptions.NoPartitionException()
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

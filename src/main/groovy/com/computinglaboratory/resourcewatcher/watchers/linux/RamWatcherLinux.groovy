package com.computinglaboratory.resourcewatcher.watchers.linux

import com.computinglaboratory.resourcewatcher.core.Memory
import com.computinglaboratory.resourcewatcher.core.ProcessCommand
import com.computinglaboratory.resourcewatcher.core.Report
import com.computinglaboratory.resourcewatcher.watchers.interfaces.RamWatcher

class RamWatcherLinux implements RamWatcher {

    @Override
    Report<Memory> getTotalMemory() throws IOError {
        def value = new ProcessCommand("cat /proc/meminfo").by {
            def lines = it.split("\n")
            for (def line : lines) {
                if (line.split(":")[0] == "MemTotal") {
                    return Long.valueOf(line.split(" ")[-2])
                }
            }
        }
        return new Report(new Memory(value))
    }

    @Override
    Report<Memory> getFreeMemory() throws IOError {
        def value = new ProcessCommand("cat /proc/meminfo").by {
            def lines = it.split("\n")
            for (def line : lines) {
                if (line.split(":")[0] == "MemFree") {
                    return Long.valueOf(line.split(" ")[-2])
                }
            }
        }
        return new Report(new Memory(value))
    }

    @Override
    Report<Memory> getAvailableMemory() throws IOError {
        def value = new ProcessCommand("cat /proc/meminfo").by {
            def lines = it.split("\n")
            for (def line : lines) {
                if (line.split(":")[0] == "MemAvailable") {
                    return Long.valueOf(line.split(" ")[-2])
                }
            }
        }
        return new Report(new Memory(value))
    }

    @Override
    Report<Memory> getBuffers() throws IOError {
        def value = new ProcessCommand("cat /proc/meminfo").by {
            def lines = it.split("\n")
            for (def line : lines) {
                if (line.split(":")[0] == "Buffers") {
                    return Long.valueOf(line.split(" ")[-2])
                }
            }
        }
        return new Report(new Memory(value))
    }

    @Override
    Report<Memory> getCached() throws IOError {
        def value = new ProcessCommand("cat /proc/meminfo").by {
            def lines = it.split("\n")
            for (def line : lines) {
                if (line.split(":")[0] == "Cached") {
                    return Long.valueOf(line.split(" ")[-2])
                }
            }
        }
        return new Report(new Memory(value))
    }
}

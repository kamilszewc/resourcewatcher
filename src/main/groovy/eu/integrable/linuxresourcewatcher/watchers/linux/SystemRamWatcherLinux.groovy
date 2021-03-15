package eu.integrable.linuxresourcewatcher.watchers.linux

import eu.integrable.linuxresourcewatcher.core.Memory
import eu.integrable.linuxresourcewatcher.core.ProcessCommand
import eu.integrable.linuxresourcewatcher.core.Report
import eu.integrable.linuxresourcewatcher.watchers.SystemRamWatcher

class SystemRamWatcherLinux implements SystemRamWatcher {

    @Override
    Report<Memory> getTotalMemory() {
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
    Report<Memory> getFreeMemory() {
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
    Report<Memory> getAvailableMemory() {
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
    Report<Memory> getBuffers() {
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
    Report<Memory> getCached() {
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

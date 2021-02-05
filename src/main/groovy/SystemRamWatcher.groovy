
class SystemRamWatcher {

    Report getTotalMemory() {
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

    Report getFreeMemory() {
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

    Report getAvailableMemory() {
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

    Report getBuffers() {
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

    Report getCached() {
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

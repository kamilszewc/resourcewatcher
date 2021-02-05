package eu.integrable.linuxresourcewatcher

class ProcessWatcher {

    Report<Memory> getProcessResidentSetSizeMemory(Long processId) {
        def value = new ProcessCommand("ps -o rss $processId").by {
            def lines = it.split("\n")
            Long.valueOf(lines[1].trim())
        }
        return new Report<>(new Memory(value))
    }

    Report<Memory> getProcessVirtualMemory(Long processId) {
        def value = new ProcessCommand("ps -o vsz $processId").by {
            def lines = it.split("\n")
            Long.valueOf(lines[1].trim())
        }
        return new Report(new Memory(value))
    }

    Report<List<Long>> getChildrenTree(Long processId) {
        def value = new ProcessCommand("pgrep -P $processId").by {
            Set processIds = [processId]
            def lines = it.split("\n")
            for (def line : lines) {
                try {
                    processIds << Long.valueOf(line.trim())

                    def subtree = getChildrenTree(Long.valueOf(line.trim())).value
                    if (subtree.size() > 0) {
                        processIds += subtree
                    }
                } catch (NumberFormatException ex) {

                }
            }
            processIds
        }
        return new Report(value)
    }

    Report<Memory> getProcessResidentSetSizeWithChildrenMemory(Long processId) {
        def childrenProcesses = getChildrenTree(processId).value
        def value = childrenProcesses.inject(0) { result, i -> result + getProcessResidentSetSizeMemory(i).value.KB() }
        return new Report(new Memory(value))
    }


    Report<Memory> getProcessVirtualWithChildrenMemory(Long processId) {
        def childrenProcesses = getChildrenTree(processId).value
        def value = childrenProcesses.inject(0) { result, i -> result + getProcessVirtualMemory(i).value.KB() }
        return new Report(new Memory(value))
    }
}

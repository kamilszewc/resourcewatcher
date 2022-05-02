package com.computinglaboratory.linuxresourcewatcher.watchers.macos


import com.computinglaboratory.linuxresourcewatcher.core.Memory
import com.computinglaboratory.linuxresourcewatcher.core.ProcessCommand
import com.computinglaboratory.linuxresourcewatcher.core.Report
import com.computinglaboratory.linuxresourcewatcher.watchers.ProcessWatcher

import java.time.Duration
import java.time.LocalTime

class ProcessWatcherMac implements ProcessWatcher {

    @Override
    Report<Memory> getProcessResidentSetSizeMemory(Long processId) throws IOError, com.computinglaboratory.linuxresourcewatcher.exceptions.NoProcessFoundException {
        def value = new ProcessCommand("ps -o rss $processId").by {
            try {
                def lines = it.split("\n")
                Long.valueOf(lines[1].trim())
            } catch (Exception ex) {
                throw new com.computinglaboratory.linuxresourcewatcher.exceptions.NoProcessFoundException()
            }
        }
        return new Report(new Memory(value))
    }

    @Override
    Report<Memory> getProcessVirtualMemory(Long processId) throws IOError, com.computinglaboratory.linuxresourcewatcher.exceptions.NoProcessFoundException {
        def value = new ProcessCommand("ps -o vsz $processId").by {
            try {
                def lines = it.split("\n")
                Long.valueOf(lines[1].trim())
            } catch (Exception ex) {
                throw new com.computinglaboratory.linuxresourcewatcher.exceptions.NoProcessFoundException()
            }
        }
        return new Report(new Memory(value))
    }

    @Override
    Report<List<Long>> getChildrenTree(Long processId) throws IOError {
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

    @Override
    Report<Memory> getProcessResidentSetSizeWithChildrenMemory(Long processId) throws IOError {
        def childrenProcesses = getChildrenTree(processId).value
        def value = childrenProcesses.inject(0) { result, i ->
            try {
                result + getProcessResidentSetSizeMemory(i).value.KB()
            } catch (com.computinglaboratory.linuxresourcewatcher.exceptions.NoProcessFoundException ex) {
                result
            }
        }
        return new Report(new Memory(value))
    }

    @Override
    Report<Memory> getProcessVirtualWithChildrenMemory(Long processId) throws IOError {
        def childrenProcesses = getChildrenTree(processId).value
        def value = childrenProcesses.inject(0) { result, i ->
            try {
                result + getProcessVirtualMemory(i).value.KB()
            } catch (com.computinglaboratory.linuxresourcewatcher.exceptions.NoProcessFoundException ex) {
                result
            }
        }
        return new Report(new Memory(value))
    }

    @Override
    Report<Duration> getProcessCpuTime(Long processId) throws IOError, com.computinglaboratory.linuxresourcewatcher.exceptions.NoProcessFoundException {
        def value = new ProcessCommand("ps -o time $processId").by {
            try {
                def lines = it.split("\n")
                Duration.parse(lines[1].trim())
                //Duration.between(LocalTime.MIN, LocalTime.parse(lines[1].trim()))
            } catch (Exception ex) {
                ex.printStackTrace()
                throw new com.computinglaboratory.linuxresourcewatcher.exceptions.NoProcessFoundException()
            }
        }
        return new Report(value)
    }

    @Override
    Report<Memory> getProcessCpuTimeWithChildren(Long processId) throws IOError {
        def childrenProcesses = getChildrenTree(processId).value
        def value = childrenProcesses.inject(Duration.between(LocalTime.now(), LocalTime.now())) { result, i ->
            try {
                result.plus(getProcessVirtualMemory(i).value.KB())
            } catch (com.computinglaboratory.linuxresourcewatcher.exceptions.NoProcessFoundException ex) {}
        }
        return new Report(value)
    }

}

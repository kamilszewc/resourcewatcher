package eu.integrable.linuxresourcewatcher.watchers.windows

import eu.integrable.linuxresourcewatcher.core.Memory
import eu.integrable.linuxresourcewatcher.core.ProcessCommand
import eu.integrable.linuxresourcewatcher.core.Report
import eu.integrable.linuxresourcewatcher.exceptions.NoProcessFoundException
import eu.integrable.linuxresourcewatcher.watchers.ProcessWatcher

import java.time.Duration
import java.time.LocalTime

class ProcessWatcherWindows implements ProcessWatcher {

    @Override
    Report<Memory> getProcessResidentSetSizeMemory(Long processId) {
        return null
    }

    @Override
    Report<Memory> getProcessVirtualMemory(Long processId) {
        return null
    }

    @Override
    Report<List<Long>> getChildrenTree(Long processId) {
        return null
    }

    @Override
    Report<Memory> getProcessResidentSetSizeWithChildrenMemory(Long processId) {
        return null
    }

    @Override
    Report<Memory> getProcessVirtualWithChildrenMemory(Long processId) {
        return null
    }

    @Override
    Report<Duration> getProcessCpuTime(Long processId) {
        return null
    }

    @Override
    Report<Memory> getProcessCpuTimeWithChildren(Long processId) {
        return null
    }

}

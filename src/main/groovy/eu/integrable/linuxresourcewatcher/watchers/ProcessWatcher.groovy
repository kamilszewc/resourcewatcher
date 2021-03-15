package eu.integrable.linuxresourcewatcher.watchers

import eu.integrable.linuxresourcewatcher.core.Memory
import eu.integrable.linuxresourcewatcher.core.Report
import eu.integrable.linuxresourcewatcher.exceptions.NoProcessFoundException

import java.time.Duration
import java.time.LocalTime

interface ProcessWatcher {

    Report<Memory> getProcessResidentSetSizeMemory(Long processId)

    Report<Memory> getProcessVirtualMemory(Long processId)

    Report<List<Long>> getChildrenTree(Long processId)

    Report<Memory> getProcessResidentSetSizeWithChildrenMemory(Long processId)

    Report<Memory> getProcessVirtualWithChildrenMemory(Long processId)

    Report<Duration> getProcessCpuTime(Long processId)

    Report<Memory> getProcessCpuTimeWithChildren(Long processId)

}

package eu.integrable.linuxresourcewatcher.watchers

import eu.integrable.linuxresourcewatcher.core.Memory
import eu.integrable.linuxresourcewatcher.core.Report
import eu.integrable.linuxresourcewatcher.exceptions.NoProcessFoundException

import java.time.Duration
import java.time.LocalTime

interface ProcessWatcher {

    Report<Memory> getProcessResidentSetSizeMemory(Long processId) throws IOError, NoProcessFoundException

    Report<Memory> getProcessVirtualMemory(Long processId) throws IOError, NoProcessFoundException

    Report<List<Long>> getChildrenTree(Long processId) throws IOError

    Report<Memory> getProcessResidentSetSizeWithChildrenMemory(Long processId) throws IOError

    Report<Memory> getProcessVirtualWithChildrenMemory(Long processId) throws IOError

    Report<Duration> getProcessCpuTime(Long processId) throws IOError, NoProcessFoundException

    Report<Memory> getProcessCpuTimeWithChildren(Long processId) throws IOError

}

package com.computinglaboratory.linuxresourcewatcher.watchers


import com.computinglaboratory.linuxresourcewatcher.core.Memory

import java.time.Duration

interface ProcessWatcher {

    com.computinglaboratory.linuxresourcewatcher.core.Report<Memory> getProcessResidentSetSizeMemory(Long processId) throws IOError, com.computinglaboratory.linuxresourcewatcher.exceptions.NoProcessFoundException

    com.computinglaboratory.linuxresourcewatcher.core.Report<Memory> getProcessVirtualMemory(Long processId) throws IOError, com.computinglaboratory.linuxresourcewatcher.exceptions.NoProcessFoundException

    com.computinglaboratory.linuxresourcewatcher.core.Report<List<Long>> getChildrenTree(Long processId) throws IOError

    com.computinglaboratory.linuxresourcewatcher.core.Report<Memory> getProcessResidentSetSizeWithChildrenMemory(Long processId) throws IOError

    com.computinglaboratory.linuxresourcewatcher.core.Report<Memory> getProcessVirtualWithChildrenMemory(Long processId) throws IOError

    com.computinglaboratory.linuxresourcewatcher.core.Report<Duration> getProcessCpuTime(Long processId) throws IOError, com.computinglaboratory.linuxresourcewatcher.exceptions.NoProcessFoundException

    com.computinglaboratory.linuxresourcewatcher.core.Report<Memory> getProcessCpuTimeWithChildren(Long processId) throws IOError

}

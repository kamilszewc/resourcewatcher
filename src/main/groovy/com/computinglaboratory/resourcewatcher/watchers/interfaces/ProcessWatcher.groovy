package com.computinglaboratory.resourcewatcher.watchers.interfaces


import com.computinglaboratory.resourcewatcher.core.*
import com.computinglaboratory.resourcewatcher.exceptions.NoProcessFoundException

import java.time.Duration

interface ProcessWatcher {

    Report<Memory> getProcessResidentSetSizeMemory(Long processId) throws IOError, NoProcessFoundException

    Report<Memory> getProcessVirtualMemory(Long processId) throws IOError, NoProcessFoundException

    Report<List<Long>> getChildrenTree(Long processId) throws IOError

    Report<Memory> getProcessResidentSetSizeWithChildrenMemory(Long processId) throws IOError

    Report<Memory> getProcessVirtualWithChildrenMemory(Long processId) throws IOError

    Report<Duration> getProcessCpuTime(Long processId) throws IOError, NoProcessFoundException

    Report<Memory> getProcessCpuTimeWithChildren(Long processId) throws IOError

}

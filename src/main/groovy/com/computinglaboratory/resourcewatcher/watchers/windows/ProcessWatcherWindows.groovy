package com.computinglaboratory.resourcewatcher.watchers.windows


import com.computinglaboratory.resourcewatcher.core.Memory
import com.computinglaboratory.resourcewatcher.core.Report
import com.computinglaboratory.resourcewatcher.watchers.interfaces.ProcessWatcher
import com.computinglaboratory.resourcewatcher.exceptions.NoProcessFoundException

import java.time.Duration

class ProcessWatcherWindows implements ProcessWatcher {

    @Override
    Report<Memory> getProcessResidentSetSizeMemory(Long processId) throws IOError, NoProcessFoundException {
        return null
    }

    @Override
    Report<Memory> getProcessVirtualMemory(Long processId) throws IOError, NoProcessFoundException {
        return null
    }

    @Override
    Report<List<Long>> getChildrenTree(Long processId) throws IOError {
        return null
    }

    @Override
    Report<Memory> getProcessResidentSetSizeWithChildrenMemory(Long processId) throws IOError {
        return null
    }

    @Override
    Report<Memory> getProcessVirtualWithChildrenMemory(Long processId) throws IOError {
        return null
    }

    @Override
    Report<Duration> getProcessCpuTime(Long processId) throws IOError, NoProcessFoundException {
        return null
    }

    @Override
    Report<Memory> getProcessCpuTimeWithChildren(Long processId) throws IOError{
        return null
    }

}

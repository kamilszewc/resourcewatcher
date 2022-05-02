package com.computinglaboratory.linuxresourcewatcher.watchers.windows


import com.computinglaboratory.linuxresourcewatcher.core.Memory
import com.computinglaboratory.linuxresourcewatcher.core.Report
import com.computinglaboratory.linuxresourcewatcher.watchers.ProcessWatcher

import java.time.Duration

class ProcessWatcherWindows implements ProcessWatcher {

    @Override
    Report<Memory> getProcessResidentSetSizeMemory(Long processId) throws IOError, com.computinglaboratory.linuxresourcewatcher.exceptions.NoProcessFoundException {
        return null
    }

    @Override
    Report<Memory> getProcessVirtualMemory(Long processId) throws IOError, com.computinglaboratory.linuxresourcewatcher.exceptions.NoProcessFoundException {
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
    Report<Duration> getProcessCpuTime(Long processId) throws IOError, com.computinglaboratory.linuxresourcewatcher.exceptions.NoProcessFoundException {
        return null
    }

    @Override
    Report<Memory> getProcessCpuTimeWithChildren(Long processId) throws IOError{
        return null
    }

}

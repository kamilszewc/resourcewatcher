package com.computinglaboratory.resourcewatcher.watchers.windows


import com.computinglaboratory.resourcewatcher.core.Report
import com.computinglaboratory.resourcewatcher.watchers.interfaces.SystemProcessesWatcher

class SystemProcessesWatcherWindows implements SystemProcessesWatcher {

    @Override
    Report<Long> getNumberOfProcesses() throws IOError {
        return new Report<Long>(10)
    }

}

package com.computinglaboratory.linuxresourcewatcher.watchers.windows


import com.computinglaboratory.linuxresourcewatcher.core.Report
import com.computinglaboratory.linuxresourcewatcher.watchers.SystemProcessesWatcher

class SystemProcessesWatcherWindows implements SystemProcessesWatcher {

    @Override
    Report<Long> getNumberOfProcesses() throws IOError {
        return new Report<Long>(10)
    }

}

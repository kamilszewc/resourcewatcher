package com.computinglaboratory.linuxresourcewatcher.watchers.macos

import com.computinglaboratory.linuxresourcewatcher.core.ProcessCommand
import com.computinglaboratory.linuxresourcewatcher.core.Report
import com.computinglaboratory.linuxresourcewatcher.watchers.SystemProcessesWatcher

class SystemProcessesWatcherMac implements SystemProcessesWatcher {

    @Override
    Report<Long> getNumberOfProcesses() throws IOError {
        def value = new ProcessCommand("ps -e").by {
            it.split("\n").size() - 1
        }
        return new Report<Long>(value)
    }

}

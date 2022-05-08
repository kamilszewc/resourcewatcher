package com.computinglaboratory.resourcewatcher.watchers.macos

import com.computinglaboratory.resourcewatcher.core.ProcessCommand
import com.computinglaboratory.resourcewatcher.core.Report
import com.computinglaboratory.resourcewatcher.watchers.interfaces.SystemProcessesWatcher

class SystemProcessesWatcherMac implements SystemProcessesWatcher {

    @Override
    Report<Long> getNumberOfProcesses() throws IOError {
        def value = new ProcessCommand("ps -e").by {
            it.split("\n").size() - 1
        }
        return new Report<Long>(value)
    }

}

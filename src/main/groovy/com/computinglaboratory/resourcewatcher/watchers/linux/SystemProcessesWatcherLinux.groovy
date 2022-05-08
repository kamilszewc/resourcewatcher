package com.computinglaboratory.resourcewatcher.watchers.linux

import com.computinglaboratory.resourcewatcher.core.ProcessCommand
import com.computinglaboratory.resourcewatcher.core.Report
import com.computinglaboratory.resourcewatcher.watchers.interfaces.SystemProcessesWatcher

class SystemProcessesWatcherLinux implements SystemProcessesWatcher {

    @Override
    Report<Long> getNumberOfProcesses() throws IOError {
        def value = new ProcessCommand("ps -eo nlwp").by {
            def sum = 0
            def lines = it.split("\n")
            for (int i=1; i<lines.size(); i++) {
                def line = lines[i]
                sum += Integer.valueOf(line.trim())
            }
            sum
        }
        return new Report<Long>(value)
    }

}

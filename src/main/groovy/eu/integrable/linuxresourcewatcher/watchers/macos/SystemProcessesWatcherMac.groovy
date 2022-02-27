package eu.integrable.linuxresourcewatcher.watchers.macos

import eu.integrable.linuxresourcewatcher.core.ProcessCommand
import eu.integrable.linuxresourcewatcher.core.Report
import eu.integrable.linuxresourcewatcher.watchers.SystemProcessesWatcher

class SystemProcessesWatcherMac implements SystemProcessesWatcher {

    @Override
    Report<Long> getNumberOfProcesses() throws IOError {
        def value = new ProcessCommand("ps -e").by {
            it.split("\n").size() - 1
        }
        return new Report<Long>(value)
    }

}

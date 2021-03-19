package eu.integrable.linuxresourcewatcher.watchers

import eu.integrable.linuxresourcewatcher.core.Report

interface SystemProcessesWatcher {

    Report<Long> getNumberOfProcesses() throws IOError
}

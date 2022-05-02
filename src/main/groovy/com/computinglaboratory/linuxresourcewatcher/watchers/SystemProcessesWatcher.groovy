package com.computinglaboratory.linuxresourcewatcher.watchers

import com.computinglaboratory.linuxresourcewatcher.core.Report

interface SystemProcessesWatcher {

    Report<Long> getNumberOfProcesses() throws IOError
}

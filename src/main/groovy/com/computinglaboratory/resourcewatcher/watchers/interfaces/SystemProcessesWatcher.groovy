package com.computinglaboratory.resourcewatcher.watchers.interfaces

import com.computinglaboratory.resourcewatcher.core.Report

interface SystemProcessesWatcher {

    Report<Long> getNumberOfProcesses() throws IOError
}

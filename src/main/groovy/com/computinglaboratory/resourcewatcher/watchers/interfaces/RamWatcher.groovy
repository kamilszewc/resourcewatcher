package com.computinglaboratory.resourcewatcher.watchers.interfaces

import com.computinglaboratory.resourcewatcher.core.Memory
import com.computinglaboratory.resourcewatcher.core.Report

interface RamWatcher {

    Report<Memory> getTotalMemory() throws IOError

    Report<Memory> getFreeMemory() throws IOError

    Report<Memory> getAvailableMemory() throws IOError

    Report<Memory> getBuffers() throws IOError

    Report<Memory> getCached() throws IOError
}

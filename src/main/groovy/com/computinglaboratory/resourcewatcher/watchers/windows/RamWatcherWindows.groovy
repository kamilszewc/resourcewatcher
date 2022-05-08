package com.computinglaboratory.resourcewatcher.watchers.windows

import com.computinglaboratory.resourcewatcher.core.Memory
import com.computinglaboratory.resourcewatcher.core.Report
import com.computinglaboratory.resourcewatcher.watchers.interfaces.RamWatcher

class RamWatcherWindows implements RamWatcher {

    @Override
    Report<Memory> getTotalMemory() throws IOError {
        return null
    }

    @Override
    Report<Memory> getFreeMemory() throws IOError {
        return null
    }

    @Override
    Report<Memory> getAvailableMemory() throws IOError {
        return null
    }

    @Override
    Report<Memory> getBuffers() throws IOError {
        return null
    }

    @Override
    Report<Memory> getCached() throws IOError {
        return null
    }
}

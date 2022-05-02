package com.computinglaboratory.linuxresourcewatcher.watchers.windows

import com.computinglaboratory.linuxresourcewatcher.core.Memory
import com.computinglaboratory.linuxresourcewatcher.core.Report
import com.computinglaboratory.linuxresourcewatcher.watchers.RamWatcher

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

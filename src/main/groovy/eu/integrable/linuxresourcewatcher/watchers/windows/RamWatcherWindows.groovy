package eu.integrable.linuxresourcewatcher.watchers.windows

import eu.integrable.linuxresourcewatcher.core.Memory
import eu.integrable.linuxresourcewatcher.core.Report
import eu.integrable.linuxresourcewatcher.watchers.RamWatcher

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

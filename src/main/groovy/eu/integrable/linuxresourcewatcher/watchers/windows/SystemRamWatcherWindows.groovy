package eu.integrable.linuxresourcewatcher.watchers.windows

import eu.integrable.linuxresourcewatcher.core.Memory
import eu.integrable.linuxresourcewatcher.core.ProcessCommand
import eu.integrable.linuxresourcewatcher.core.Report
import eu.integrable.linuxresourcewatcher.watchers.SystemRamWatcher

class SystemRamWatcherWindows implements SystemRamWatcher {

    @Override
    Report<Memory> getTotalMemory() {
        return null
    }

    @Override
    Report<Memory> getFreeMemory() {
        return null
    }

    @Override
    Report<Memory> getAvailableMemory() {
        return null
    }

    @Override
    Report<Memory> getBuffers() {
        return null
    }

    @Override
    Report<Memory> getCached() {
        return null
    }
}

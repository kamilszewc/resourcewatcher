package eu.integrable.linuxresourcewatcher.watchers

import eu.integrable.linuxresourcewatcher.core.Memory
import eu.integrable.linuxresourcewatcher.core.Report

interface SystemRamWatcher {

    Report<Memory> getTotalMemory()

    Report<Memory> getFreeMemory()

    Report<Memory> getAvailableMemory()

    Report<Memory> getBuffers()

    Report<Memory> getCached()
}

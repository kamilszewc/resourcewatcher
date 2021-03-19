package eu.integrable.linuxresourcewatcher.watchers

import eu.integrable.linuxresourcewatcher.core.Memory
import eu.integrable.linuxresourcewatcher.core.Report

interface RamWatcher {

    Report<Memory> getTotalMemory() throws IOError

    Report<Memory> getFreeMemory() throws IOError

    Report<Memory> getAvailableMemory() throws IOError

    Report<Memory> getBuffers() throws IOError

    Report<Memory> getCached() throws IOError
}

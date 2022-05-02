package com.computinglaboratory.linuxresourcewatcher.watchers

import com.computinglaboratory.linuxresourcewatcher.core.Memory
import com.computinglaboratory.linuxresourcewatcher.core.Report

interface RamWatcher {

    Report<Memory> getTotalMemory() throws IOError

    Report<Memory> getFreeMemory() throws IOError

    Report<Memory> getAvailableMemory() throws IOError

    Report<Memory> getBuffers() throws IOError

    Report<Memory> getCached() throws IOError
}

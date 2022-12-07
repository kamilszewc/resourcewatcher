package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.core.Memory;

import java.io.IOError;
import java.io.IOException;

public interface RamWatcher {
    Memory getTotalMemory() throws IOError, IOException;

    Memory getFreeMemory() throws IOError, IOException;

    Memory getAvailableMemory() throws IOError, IOException;
}

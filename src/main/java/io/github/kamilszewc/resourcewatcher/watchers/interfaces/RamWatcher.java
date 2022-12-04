package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.core.Memory;

import java.io.IOError;
import java.io.IOException;

public interface RamWatcher {
    public abstract Memory getTotalMemory() throws IOError, IOException;

    public abstract Memory getFreeMemory() throws IOError, IOException;

    public abstract Memory getAvailableMemory() throws IOError, IOException;
}

package com.computinglaboratory.resourcewatcher.watchers.interfaces;

import com.computinglaboratory.resourcewatcher.core.Memory;

import java.io.IOError;
import java.io.IOException;

public interface RamWatcher {
    public abstract Memory getTotalMemory() throws IOError, IOException;

    public abstract Memory getFreeMemory() throws IOError, IOException;

    public abstract Memory getAvailableMemory() throws IOError, IOException;

    public abstract Memory getBuffers() throws IOError, IOException;

    public abstract Memory getCachedMemory() throws IOError, IOException;
}

package com.computinglaboratory.resourcewatcher.watchers.windows;

import com.computinglaboratory.resourcewatcher.core.Memory;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.RamWatcher;

import java.io.IOError;

public class RamWatcherWindows implements RamWatcher {
    @Override
    public Memory getTotalMemory() throws IOError {
        return null;
    }

    @Override
    public Memory getFreeMemory() throws IOError {
        return null;
    }

    @Override
    public Memory getAvailableMemory() throws IOError {
        return null;
    }

    @Override
    public Memory getBuffers() throws IOError {
        return null;
    }

    @Override
    public Memory getCached() throws IOError {
        return null;
    }

}

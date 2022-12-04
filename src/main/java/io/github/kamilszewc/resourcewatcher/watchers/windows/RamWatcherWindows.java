package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.RamWatcher;

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

}

package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.watchers.interfaces.SystemWatcher;

import java.io.IOError;

public class SystemWatcherWindows implements SystemWatcher {
    @Override
    public Integer getNumberOfProcesses() throws IOError {
        return null;
    }

}

package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.watchers.interfaces.SystemProcessesWatcher;

import java.io.IOError;

public class SystemProcessesWatcherWindows implements SystemProcessesWatcher {
    @Override
    public Integer getNumberOfProcesses() throws IOError {
        return null;
    }

}

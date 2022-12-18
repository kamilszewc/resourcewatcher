package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.watchers.interfaces.SystemWatcher;

import java.io.IOError;
import java.io.IOException;

public class SystemWatcherWindows implements SystemWatcher {
    @Override
    public Integer getNumberOfProcesses() throws IOError {
        return null;
    }

    @Override
    public String getKernelReleaseVersion() throws IOException {
        return null;
    }

    @Override
    public String getKernelVersion() throws IOException {
        return null;
    }

    @Override
    public String getNodeName() throws IOException {
        return null;
    }

    @Override
    public String getSystemName() throws IOException {
        return null;
    }

    @Override
    public String getSystemVersion() throws IOException {
        return null;
    }

    @Override
    public String getSystemId() throws IOException {
        return null;
    }

}

package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.core.CpuInfo;
import io.github.kamilszewc.resourcewatcher.core.ProcessCommand;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.CpuWatcher;

import java.io.IOException;

public class CpuWatcherWindows implements CpuWatcher {

    @Override
    public CpuInfo getCpuInfo() throws IOException {
        return null;
    }
}

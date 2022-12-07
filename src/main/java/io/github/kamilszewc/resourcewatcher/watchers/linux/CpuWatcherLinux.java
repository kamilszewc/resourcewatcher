package io.github.kamilszewc.resourcewatcher.watchers.linux;

import io.github.kamilszewc.resourcewatcher.core.CpuInfo;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.CpuWatcher;

import java.io.IOException;


public class CpuWatcherLinux implements CpuWatcher {

    @Override
    public CpuInfo getCpuInfo() throws IOException {
        return null;
    }
}

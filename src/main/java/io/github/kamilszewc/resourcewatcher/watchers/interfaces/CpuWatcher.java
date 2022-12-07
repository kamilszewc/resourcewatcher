package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.core.CpuInfo;

import java.io.IOException;

public interface CpuWatcher {
    CpuInfo getCpuInfo() throws IOException;
}

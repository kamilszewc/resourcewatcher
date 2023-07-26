package com.computinglaboratory.resourcewatcher.watchers.windows;

import com.computinglaboratory.resourcewatcher.watchers.interfaces.*;
import com.computinglaboratory.resourcewatcher.watchers.universal.DiskWatcherUniversal;
import com.computinglaboratory.resourcewatcher.exceptions.NotImplementedException;

import java.nio.file.Files;

/**
 * ResourceWatcher class - Windows specialization
 */
public class ResourceWatcherWindows implements ResourceWatcher {

    /**
     * Constructor
     */
    public ResourceWatcherWindows() {}

    @Override
    public CpuWatcher getCpuWatcher() {
        return new CpuWatcherWindows();
    }

    @Override
    public DiskWatcher getDiskWatcher() {
        return new DiskWatcherUniversal();
    }

    @Override
    public NetworkWatcher getNetworkWatcher() {
        return new NetworkWatcherWindows();
    }

    @Override
    public NvidiaCudaWatcher getNvidiaCudaWatcher() {
        throw new NotImplementedException();
    }

    @Override
    public ProcessWatcher getProcessWatcher() {
        return new ProcessWatcherWindows();
    }

    @Override
    public RamWatcher getRamWatcher() {
        return new RamWatcherWindows();
    }

    @Override
    public SystemWatcher getSystemWatcher() {
        return new SystemWatcherWindows();
    }

    @Override
    public FilesWatcher getFilesWatcher() { throw new NotImplementedException(); }
}

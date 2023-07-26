package com.computinglaboratory.resourcewatcher.watchers.macos;

import com.computinglaboratory.resourcewatcher.exceptions.NotImplementedException;
import com.computinglaboratory.resourcewatcher.exceptions.NotSupportedException;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.*;
import com.computinglaboratory.resourcewatcher.watchers.universal.DiskWatcherUniversal;

/**
 * ResourceWatcher class - MacOS specialization
 */
public class ResourceWatcherMac implements ResourceWatcher {

    /**
     * Constructor
     */
    public ResourceWatcherMac() {}

    @Override
    public CpuWatcher getCpuWatcher() {
        return new CpuWatcherMac();
    }

    @Override
    public DiskWatcher getDiskWatcher() {
        return new DiskWatcherUniversal();
    }

    @Override
    public NetworkWatcher getNetworkWatcher() {
        throw new NotImplementedException();
    }

    @Override
    public NvidiaCudaWatcher getNvidiaCudaWatcher() {
        throw new NotSupportedException();
    }

    @Override
    public ProcessWatcher getProcessWatcher() {
        return new ProcessWatcherMac();
    }

    @Override
    public RamWatcher getRamWatcher() {
        return new RamWatcherMac();
    }

    @Override
    public SystemWatcher getSystemWatcher() {
        return new SystemWatcherMac();
    }

    @Override
    public FilesWatcher getFilesWatcher() { return new FilesWatcherMac(); }
}

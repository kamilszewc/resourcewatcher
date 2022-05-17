package com.computinglaboratory.resourcewatcher.watchers.interfaces;

import com.computinglaboratory.resourcewatcher.core.Memory;
import com.computinglaboratory.resourcewatcher.exceptions.NoPartitionException;

import java.io.IOError;
import java.util.List;

public interface DiskWatcher {
    public abstract Memory getFreePartitionSpace(String partition) throws IOError, NoPartitionException;

    public abstract Memory getTotalPartitionSpace(String partition) throws IOError, NoPartitionException;

    public abstract Memory getUsablePartitionSpace(String partition) throws IOError, NoPartitionException;

    public abstract List<String> getListOfPartitions() throws IOError;
}

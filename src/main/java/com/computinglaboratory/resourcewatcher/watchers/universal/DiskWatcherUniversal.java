package com.computinglaboratory.resourcewatcher.watchers.universal;

import com.computinglaboratory.resourcewatcher.core.Memory;
import com.computinglaboratory.resourcewatcher.exceptions.NoPartitionException;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.DiskWatcher;

import java.io.File;
import java.io.IOError;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DiskWatcherUniversal implements DiskWatcher {

    @Override
    public Memory getFreePartitionSpace(String partition) throws IOError, NoPartitionException {

        File p = new File(partition);
        if (!p.exists()) {
            throw new NoPartitionException();
        }
        return new Memory(p.getFreeSpace() / 1024);
    }

    @Override
    public Memory getTotalPartitionSpace(String partition) throws IOError, NoPartitionException {

        File p = new File(partition);
        if (!p.exists()) {
            throw new NoPartitionException();
        }
        return new Memory(p.getTotalSpace() / 1024);
    }

    @Override
    public Memory getUsablePartitionSpace(String partition) throws IOError, NoPartitionException {

        File p = new File(partition);
        if (!p.exists()) {
            throw new NoPartitionException();
        }
        return new Memory(p.getUsableSpace() / 1024);
    }

    @Override
    public List<String> getListOfPartitions() throws IOError {

        return Arrays.stream(File.listRoots()).map(File::toString).collect(Collectors.toList());
    }

}

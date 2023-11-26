package io.github.kamilszewc.resourcewatcher.watchers.universal;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.exceptions.NoPartitionException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.DiskWatcher;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DiskWatcher class - universal for all OSes
 */
public class DiskWatcherUniversal implements DiskWatcher {

    /**
     * Constructor
     */
    public DiskWatcherUniversal() {}

    @Override
    public Memory getFreePartitionSpace(String partition) throws NoPartitionException {

        File p = new File(partition);
        if (!p.exists()) {
            throw new NoPartitionException();
        }
        return new Memory(p.getFreeSpace());
    }

    @Override
    public Memory getTotalPartitionSpace(String partition) throws NoPartitionException {

        File p = new File(partition);
        if (!p.exists()) {
            throw new NoPartitionException();
        }
        return new Memory(p.getTotalSpace());
    }

    @Override
    public Memory getUsablePartitionSpace(String partition) throws NoPartitionException {

        File p = new File(partition);
        if (!p.exists()) {
            throw new NoPartitionException();
        }
        return new Memory(p.getUsableSpace());
    }

    @Override
    public List<String> getListOfPartitions() {

        return Arrays.stream(File.listRoots()).map(File::toString).collect(Collectors.toList());
    }

}

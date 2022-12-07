package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.exceptions.NoPartitionException;

import java.io.IOError;
import java.util.List;

/**
 * The class allows to get an information about the disk store in the system.
 */
public interface DiskWatcher {
    Memory getFreePartitionSpace(String partition) throws IOError, NoPartitionException;

    Memory getTotalPartitionSpace(String partition) throws IOError, NoPartitionException;

    Memory getUsablePartitionSpace(String partition) throws IOError, NoPartitionException;

    List<String> getListOfPartitions() throws IOError;
}

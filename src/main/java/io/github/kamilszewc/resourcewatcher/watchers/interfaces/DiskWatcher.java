package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.exceptions.NoPartitionException;

import java.io.IOError;
import java.util.List;

/**
 * The class allows to get an information about the disk store in the system.
 */
public interface DiskWatcher {

    /**
     * Get free space in given partition
     * @param partition partition name
     * @return free space
     * @throws IOError
     * @throws NoPartitionException
     */
    Memory getFreePartitionSpace(String partition) throws IOError, NoPartitionException;

    /**
     * Get total space in given partition
     * @param partition partition name
     * @return total space
     * @throws IOError
     * @throws NoPartitionException
     */
    Memory getTotalPartitionSpace(String partition) throws IOError, NoPartitionException;

    /**
     * Get usable space in given partition
     * @param partition partition name
     * @return usable space
     * @throws IOError
     * @throws NoPartitionException
     */
    Memory getUsablePartitionSpace(String partition) throws IOError, NoPartitionException;

    /**
     * Get list of partitions
     * @return list of partitions
     * @throws IOError
     */
    List<String> getListOfPartitions() throws IOError;
}

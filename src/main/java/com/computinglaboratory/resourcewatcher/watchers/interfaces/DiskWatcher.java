package com.computinglaboratory.resourcewatcher.watchers.interfaces;

import com.computinglaboratory.resourcewatcher.core.Memory;
import com.computinglaboratory.resourcewatcher.exceptions.NoPartitionException;

import java.util.List;

/**
 * The class allows to get an information about the disk store in the system.
 */
public interface DiskWatcher {

    /**
     * Get free space in given partition
     * @param partition partition name
     * @return free space
     * @throws NoPartitionException if there is no partition
     */
    Memory getFreePartitionSpace(String partition) throws NoPartitionException;

    /**
     * Get total space in given partition
     * @param partition partition name
     * @return total space
     * @throws NoPartitionException if there is no partition
     */
    Memory getTotalPartitionSpace(String partition) throws NoPartitionException;

    /**
     * Get usable space in given partition
     * @param partition partition name
     * @return usable space
     * @throws NoPartitionException if there is no partition
     */
    Memory getUsablePartitionSpace(String partition) throws NoPartitionException;

    /**
     * Get list of partitions
     * @return list of partitions
     */
    List<String> getListOfPartitions();
}

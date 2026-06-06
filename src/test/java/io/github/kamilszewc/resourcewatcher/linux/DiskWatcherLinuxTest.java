package io.github.kamilszewc.resourcewatcher.linux;

import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory;
import io.github.kamilszewc.resourcewatcher.exceptions.NoPartitionException;
import io.github.kamilszewc.resourcewatcher.exceptions.UnknownOperatingSystemException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.DiskWatcher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiskWatcherLinuxTest {

    @Test
    public void getFreePartitionSpace() throws UnknownOperatingSystemException, NoPartitionException {
        // given
        DiskWatcher diskWatcher = ResourceWatcherFactory.create().getDiskWatcher();

        // when
        var partitionSize = diskWatcher.getFreePartitionSpace("/");

        // then
        assertNotNull(partitionSize);
    }

    @Test
    public void getFreePartitionSpace_NoPartitionException() throws UnknownOperatingSystemException {
        // given
        DiskWatcher diskWatcher = ResourceWatcherFactory.create().getDiskWatcher();

        // when & then
        assertThrows(NoPartitionException.class, () -> {
            diskWatcher.getFreePartitionSpace("dsffd");
        });
    }

    @Test
    public void getUsablePartitionSpace() throws UnknownOperatingSystemException, NoPartitionException {
        // given
        DiskWatcher diskWatcher = ResourceWatcherFactory.create().getDiskWatcher();

        // when
        var partitionSize = diskWatcher.getUsablePartitionSpace("/");

        // then
        assertNotNull(partitionSize);
    }

    @Test
    public void getUsablePartitionSpace_NoPartitionException() throws UnknownOperatingSystemException {
        // given
        DiskWatcher diskWatcher = ResourceWatcherFactory.create().getDiskWatcher();

        // when & then
        assertThrows(NoPartitionException.class, () -> {
            diskWatcher.getUsablePartitionSpace("dsffd");
        });
    }

    @Test
    public void getTotalPartitionSpace() throws UnknownOperatingSystemException, NoPartitionException {
        // given
        DiskWatcher diskWatcher = ResourceWatcherFactory.create().getDiskWatcher();

        // when
        var partitionSize = diskWatcher.getTotalPartitionSpace("/");

        // then
        assertNotNull(partitionSize);
    }

    @Test
    public void getTotalPartitionSpace_NoPartitionException() throws UnknownOperatingSystemException {
        // given
        DiskWatcher diskWatcher = ResourceWatcherFactory.create().getDiskWatcher();

        // when & then
        assertThrows(NoPartitionException.class, () -> {
            diskWatcher.getTotalPartitionSpace("dsffd");
        });
    }

    @Test
    public void getListOfPartitions() throws UnknownOperatingSystemException {
        // given
        DiskWatcher diskWatcher = ResourceWatcherFactory.create().getDiskWatcher();

        // when
        var partitions = diskWatcher.getListOfPartitions();

        // then
        assertNotNull(partitions);
    }
}
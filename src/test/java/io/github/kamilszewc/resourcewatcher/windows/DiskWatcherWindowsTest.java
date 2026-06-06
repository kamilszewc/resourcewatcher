package io.github.kamilszewc.resourcewatcher.windows;

import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory;
import io.github.kamilszewc.resourcewatcher.exceptions.NoPartitionException;
import io.github.kamilszewc.resourcewatcher.exceptions.UnknownOperatingSystemException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiskWatcherWindowsTest {

    @Test
    public void getFreePartitionSpace() throws UnknownOperatingSystemException, NoPartitionException {
        // given
        var diskWatcher = ResourceWatcherFactory.create().getDiskWatcher();

        // when
        var partitionSize = diskWatcher.getFreePartitionSpace("C:");
        System.out.print(partitionSize.getGB());

        // then
        assertNotNull(partitionSize);
    }

    @Test
    public void getFreePartitionSpace_NoPartitionException() throws UnknownOperatingSystemException {
        // given
        var diskWatcher = ResourceWatcherFactory.create().getDiskWatcher();

        // when & then
        assertThrows(NoPartitionException.class, () -> {
            diskWatcher.getFreePartitionSpace("sdsfds");
        });
    }

    @Test
    public void getUsablePartitionSpace() throws UnknownOperatingSystemException, NoPartitionException {
        // given
        var diskWatcher = ResourceWatcherFactory.create().getDiskWatcher();

        // when
        var partitionSize = diskWatcher.getUsablePartitionSpace("C:");
        System.out.print(partitionSize.getGB());

        // then
        assertNotNull(partitionSize);
    }
}
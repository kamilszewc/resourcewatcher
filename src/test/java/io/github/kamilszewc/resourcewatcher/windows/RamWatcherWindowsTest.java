package io.github.kamilszewc.resourcewatcher.windows;

import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory;
import io.github.kamilszewc.resourcewatcher.exceptions.UnknownOperatingSystemException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.RamWatcher;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class RamWatcherWindowsTest {

    @Test
    public void getTotalMemoryIsNotNull() throws UnknownOperatingSystemException, IOException {
        // given
        RamWatcher systemRamWatcher = ResourceWatcherFactory.create().getRamWatcher();

        // when
        var totalMemory = systemRamWatcher.getTotalMemory();
        System.out.print(totalMemory.getMB());

        // then
        assertNotNull(totalMemory);
        assertNotEquals(0, totalMemory.getMB());
    }

    @Test
    public void getFreeMemoryIsNotNull() throws UnknownOperatingSystemException, IOException {
        // given
        RamWatcher systemRamWatcher = ResourceWatcherFactory.create().getRamWatcher();

        // when
        var freeMemory = systemRamWatcher.getFreeMemory();
        System.out.print(freeMemory.getMB());

        // then
        assertNotNull(freeMemory);
        assertNotEquals(0, freeMemory.getMB());
    }

    @Test
    public void getAvailableMemoryIsNotNull() throws UnknownOperatingSystemException, IOException {
        // given
        RamWatcher systemRamWatcher = ResourceWatcherFactory.create().getRamWatcher();

        // when
        var availableMemory = systemRamWatcher.getAvailableMemory();
        System.out.print(availableMemory.getMB());

        // then
        assertNotNull(availableMemory);
        assertNotEquals(0, availableMemory.getMB());
    }
}
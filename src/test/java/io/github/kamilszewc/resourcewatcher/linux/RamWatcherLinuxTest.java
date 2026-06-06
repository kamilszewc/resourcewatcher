package io.github.kamilszewc.resourcewatcher.linux;

import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory;
import io.github.kamilszewc.resourcewatcher.exceptions.UnknownOperatingSystemException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.RamWatcher;
import io.github.kamilszewc.resourcewatcher.watchers.linux.RamWatcherLinux;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class RamWatcherLinuxTest {

    @Test
    public void getTotalMemoryIsNotNull() throws UnknownOperatingSystemException, IOException {
        // given
        RamWatcher systemRamWatcher = ResourceWatcherFactory.create().getRamWatcher();

        // when
        var totalMemory = systemRamWatcher.getTotalMemory();

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

        // then
        assertNotNull(availableMemory);
        assertNotEquals(0, availableMemory.getMB());
    }

    @Test
    public void getBuffersIsNotNull() throws UnknownOperatingSystemException, IOException {
        // given
        RamWatcherLinux systemRamWatcher = (RamWatcherLinux) ResourceWatcherFactory.create().getRamWatcher();

        // when
        var buffers = systemRamWatcher.getBuffers();

        // then
        assertNotNull(buffers);
        assertNotEquals(0, buffers.getB());
    }

    @Test
    public void getCachedMemoryIsNotNull() throws IOException, UnknownOperatingSystemException {
        // given
        RamWatcherLinux systemRamWatcher = (RamWatcherLinux) ResourceWatcherFactory.create().getRamWatcher();

        // when
        var cached = systemRamWatcher.getCachedMemory();

        // then
        assertNotNull(cached);
        assertNotEquals(0, cached.getB());
    }
}
package io.github.kamilszewc.resourcewatcher.linux;

import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory;
import io.github.kamilszewc.resourcewatcher.exceptions.NoProcessFoundException;
import io.github.kamilszewc.resourcewatcher.exceptions.UnknownOperatingSystemException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.ProcessWatcher;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ProcessWatcherLinuxTest {

    @Test
    public void givesNonNullProcessRssMemoryReport() throws UnknownOperatingSystemException, NoProcessFoundException, IOException {
        // given
        ProcessWatcher processWatcher = ResourceWatcherFactory.create().getProcessWatcher();

        // when
        var processMemory = processWatcher.getProcessResidentSetSizeMemory(1L);
        System.out.print(processMemory.getKB());

        // then
        assertNotNull(processMemory);
    }

    @Test
    public void getProcessResidentSetSizeMemory_ThrowsExceptionWhenProcessDoesNotExist() throws UnknownOperatingSystemException {
        // given
        ProcessWatcher processWatcher = ResourceWatcherFactory.create().getProcessWatcher();

        // when & then
        assertThrows(NoProcessFoundException.class, () -> {
            processWatcher.getProcessResidentSetSizeMemory(1342342324L);
        });
    }

    @Test
    public void givesNonNullProcessWithChildrenRssMemoryReport() throws UnknownOperatingSystemException, NoProcessFoundException, IOException {
        // given
        ProcessWatcher processWatcher = ResourceWatcherFactory.create().getProcessWatcher();

        // when
        var processMemory = processWatcher.getProcessResidentSetSizeWithChildrenMemory(1L);

        // then
        assertNotNull(processMemory);
    }

    @Test
    public void givesNonNullProcessVszMemoryReport() throws UnknownOperatingSystemException, NoProcessFoundException, IOException {
        // given
        ProcessWatcher processWatcher = ResourceWatcherFactory.create().getProcessWatcher();

        // when
        var processMemory = processWatcher.getProcessVirtualMemory(1L);

        // then
        assertNotNull(processMemory);
    }

    @Test
    public void givesNonNullProcessWithChildrenVszMemoryReport() throws UnknownOperatingSystemException, NoProcessFoundException, IOException {
        // given
        ProcessWatcher processWatcher = ResourceWatcherFactory.create().getProcessWatcher();

        // when
        var processMemory = processWatcher.getProcessVirtualWithChildrenMemory(1L);

        // then
        assertNotNull(processMemory);
    }
}
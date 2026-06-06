package io.github.kamilszewc.resourcewatcher.windows;

import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory;
import io.github.kamilszewc.resourcewatcher.exceptions.NoProcessFoundException;
import io.github.kamilszewc.resourcewatcher.exceptions.UnknownOperatingSystemException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.ProcessWatcher; // Assuming base interface package
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ProcessWatcherWindowsTest {

    @Test
    public void givesNonNullProcessRssMemoryReport() throws UnknownOperatingSystemException, NoProcessFoundException, IOException {
        // given
        ProcessWatcher processWatcher = ResourceWatcherFactory.create().getProcessWatcher();

        // when
        var processMemory = processWatcher.getProcessResidentSetSizeMemory(0L);
        System.out.print(processMemory.getKB());

        // then
        assertNotNull(processMemory);
    }

    @Test
    public void getProcessResidentSetSizeMemory_RisesExceptionWhenProcessDoesNotExist() throws UnknownOperatingSystemException {
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
        var processMemory = processWatcher.getProcessResidentSetSizeWithChildrenMemory(4L);
        System.out.print(processMemory.getKB());

        // then
        assertNotNull(processMemory);
    }

    @Test
    public void givesNonNullProcessVszMemoryReport() throws UnknownOperatingSystemException, NoProcessFoundException, IOException {
        // given
        ProcessWatcher processWatcher = ResourceWatcherFactory.create().getProcessWatcher();

        // when
        var processMemory = processWatcher.getProcessVirtualMemory(0L);
        System.out.print(processMemory.getKB());

        // then
        assertNotNull(processMemory);
    }

    @Test
    public void givesNonNullProcessWithChildrenVszMemoryReport() throws UnknownOperatingSystemException, NoProcessFoundException, IOException {
        // given
        ProcessWatcher processWatcher = ResourceWatcherFactory.create().getProcessWatcher();

        // when
        var processMemory = processWatcher.getProcessVirtualWithChildrenMemory(4L);
        System.out.print(processMemory.getKB());

        // then
        assertNotNull(processMemory);
    }

    @Test
    public void givesNonNullChildrenTreeReport() throws UnknownOperatingSystemException, NoProcessFoundException, IOException {
        // given
        ProcessWatcher processWatcher = ResourceWatcherFactory.create().getProcessWatcher();

        // when
        var childrenTree = processWatcher.getChildrenTree(4L);
        System.out.print(childrenTree);

        // then
        assertNotNull(childrenTree);
    }

    @Test
    public void risesNoProcessFoundExceptionWhenGettingChildrenTreeReportOfNonExistingProcess() throws UnknownOperatingSystemException {
        // given
        ProcessWatcher processWatcher = ResourceWatcherFactory.create().getProcessWatcher();

        // when & then
        assertThrows(NoProcessFoundException.class, () -> {
            processWatcher.getChildrenTree(34543654645L); // Appended 'L' as this number exceeds the 32-bit int max value
        });
    }
}
package io.github.kamilszewc.resourcewatcher.windows;

import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory;
import io.github.kamilszewc.resourcewatcher.exceptions.UnknownOperatingSystemException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.SystemWatcher;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SystemWatcherWindowsTest {

    @Test
    public void getNumberOfProcessesIsNotNull() throws UnknownOperatingSystemException, IOException {
        // given
        SystemWatcher systemProcessesWatcher = ResourceWatcherFactory.create().getSystemWatcher();

        // when
        Integer numberOfProcesses = systemProcessesWatcher.getNumberOfProcesses();
        System.out.print(numberOfProcesses);

        // then
        assertNotNull(numberOfProcesses);
    }

    @Test
    public void getKernelReleaseVersionIsNotEmpty() throws UnknownOperatingSystemException, IOException {
        // given
        SystemWatcher systemProcessesWatcher = ResourceWatcherFactory.create().getSystemWatcher();

        // when
        String kernelReleaseVersion = systemProcessesWatcher.getKernelReleaseVersion();
        System.out.print(kernelReleaseVersion);

        // then
        assertNotNull(kernelReleaseVersion);
        assertFalse(kernelReleaseVersion.isEmpty());
    }

    @Test
    public void getKernelVersionIsNotEmpty() throws UnknownOperatingSystemException, IOException {
        // given
        SystemWatcher systemProcessesWatcher = ResourceWatcherFactory.create().getSystemWatcher();

        // when
        String kernelVersion = systemProcessesWatcher.getKernelVersion();
        System.out.print(kernelVersion);

        // then
        assertNotNull(kernelVersion);
        assertFalse(kernelVersion.isEmpty());
    }

    @Test
    public void getNodeNameIsNotEmpty() throws UnknownOperatingSystemException, IOException {
        // given
        SystemWatcher systemProcessesWatcher = ResourceWatcherFactory.create().getSystemWatcher();

        // when
        String nodeName = systemProcessesWatcher.getNodeName();
        System.out.print(nodeName);

        // then
        assertNotNull(nodeName);
        assertFalse(nodeName.isEmpty());
    }

    @Test
    public void getSystemNameIsNotEmpty() throws UnknownOperatingSystemException, IOException {
        // given
        SystemWatcher systemProcessesWatcher = ResourceWatcherFactory.create().getSystemWatcher();

        // when
        String systemName = systemProcessesWatcher.getSystemName();
        System.out.print(systemName);

        // then
        assertNotNull(systemName);
        assertFalse(systemName.isEmpty());
    }

    @Test
    public void getSystemVersionIsNotEmpty() throws UnknownOperatingSystemException, IOException {
        // given
        SystemWatcher systemProcessesWatcher = ResourceWatcherFactory.create().getSystemWatcher();

        // when
        String systemVersion = systemProcessesWatcher.getSystemVersion();
        System.out.print(systemVersion);

        // then
        assertNotNull(systemVersion);
        assertFalse(systemVersion.isEmpty());
    }

    @Test
    public void getSystemIdIsNotEmpty() throws UnknownOperatingSystemException, IOException {
        // given
        SystemWatcher systemProcessesWatcher = ResourceWatcherFactory.create().getSystemWatcher();

        // when
        String systemId = systemProcessesWatcher.getSystemId();
        System.out.print(systemId);

        // then
        assertNotNull(systemId);
        assertFalse(systemId.isEmpty());
    }
}
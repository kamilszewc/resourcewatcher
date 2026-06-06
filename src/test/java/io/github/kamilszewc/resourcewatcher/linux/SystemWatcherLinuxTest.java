package io.github.kamilszewc.resourcewatcher.linux;

import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory;
import io.github.kamilszewc.resourcewatcher.exceptions.UnknownOperatingSystemException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.SystemWatcher;
import io.github.kamilszewc.resourcewatcher.watchers.linux.SystemWatcherLinux;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SystemWatcherLinuxTest {

    @Test
    public void getNumberOfProcessesIsNotNull() throws UnknownOperatingSystemException, IOException {
        // given
        SystemWatcher systemProcessesWatcher = ResourceWatcherFactory.create().getSystemWatcher();

        // when
        Integer numberOfProcesses = systemProcessesWatcher.getNumberOfProcesses();

        // then
        assertNotNull(numberOfProcesses);
    }

    @Test
    public void getKernelReleaseVersionIsNotEmpty() throws UnknownOperatingSystemException, IOException {
        // given
        SystemWatcherLinux systemProcessesWatcher = (SystemWatcherLinux) ResourceWatcherFactory.create().getSystemWatcher();

        // when
        String kernelReleaseVersion = systemProcessesWatcher.getKernelReleaseVersion();

        // then
        assertNotNull(kernelReleaseVersion);
        assertFalse(kernelReleaseVersion.isEmpty());
    }

    @Test
    public void getKernelVersionIsNotEmpty() throws UnknownOperatingSystemException, IOException {
        // given
        SystemWatcherLinux systemProcessesWatcher = (SystemWatcherLinux) ResourceWatcherFactory.create().getSystemWatcher();

        // when
        String kernelVersion = systemProcessesWatcher.getKernelVersion();

        // then
        assertNotNull(kernelVersion);
        assertFalse(kernelVersion.isEmpty());
    }

    @Test
    public void getNodeNameIsNotEmpty() throws UnknownOperatingSystemException, IOException {
        // given
        SystemWatcherLinux systemProcessesWatcher = (SystemWatcherLinux) ResourceWatcherFactory.create().getSystemWatcher();

        // when
        String nodeName = systemProcessesWatcher.getNodeName();

        // then
        assertNotNull(nodeName);
        assertFalse(nodeName.isEmpty());
    }


    @Test
    public void getSystemNameIsNotEmpty() throws UnknownOperatingSystemException, IOException {
        // given
        SystemWatcherLinux systemProcessesWatcher = (SystemWatcherLinux) ResourceWatcherFactory.create().getSystemWatcher();

        // when
        String systemName = systemProcessesWatcher.getSystemName();

        // then
        assertNotNull(systemName);
        assertFalse(systemName.isEmpty());
    }
}
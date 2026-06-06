package io.github.kamilszewc.resourcewatcher.windows;

import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory;
import io.github.kamilszewc.resourcewatcher.exceptions.UnknownOperatingSystemException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.NetworkWatcher;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class NetworkWatcherWindowsTest {

    @Test
    public void returnsListOfNetworkInterfaces() throws UnknownOperatingSystemException, IOException {
        // given
        NetworkWatcher networkWatcher = ResourceWatcherFactory.create().getNetworkWatcher();

        // when
        var interfaces = networkWatcher.getListOfInterfaces();

        // then
        System.out.println(interfaces);
        assertNotNull(interfaces);
    }
}
package io.github.kamilszewc.resourcewatcher.linux;

import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory;
import io.github.kamilszewc.resourcewatcher.exceptions.NoNetworkInterfaceException;
import io.github.kamilszewc.resourcewatcher.exceptions.UnknownOperatingSystemException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.NetworkWatcher;
import io.github.kamilszewc.resourcewatcher.watchers.linux.NetworkWatcherLinux;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class NetworkWatcherLinuxTest {

    @Test
    public void returnsListOfNetworkInterfaces() throws UnknownOperatingSystemException, IOException {
        // given
        NetworkWatcher networkWatcher = ResourceWatcherFactory.create().getNetworkWatcher();

        // when
        var interfaces = networkWatcher.getListOfInterfaces(); // Replace ? with actual type (e.g., String)

        // then
        System.out.println(interfaces);
        assertNotNull(interfaces);
    }

    @Test
    public void returnsNotNullTransmitValuesForLoInterface() throws UnknownOperatingSystemException, NoNetworkInterfaceException, IOException, InterruptedException {
        // given
        NetworkWatcher networkWatcher = ResourceWatcherFactory.create().getNetworkWatcher();

        // when
        var speed = ((NetworkWatcherLinux)networkWatcher).getInterfaceTransmitSpeed("lo");

        // then
        System.out.println(speed.getMbs());
        assertNotNull(speed.getKbs());
    }

//    @Test
//    public void returnsNotNullReceiveValuesForLoInterface() throws UnknownOperatingSystemException, NoNetworkInterfaceException, IOException, InterruptedException {
//        // given
//        NetworkWatcher networkWatcher = ResourceWatcherFactory.create().getNetworkWatcher();
//
//        // when
//        var speed = ((NetworkWatcherLinux)networkWatcher).getInterfaceReceiveSpeed("wlp5s0");
//
//        // then
//        System.out.println(speed.getMbs());
//        assertNotNull(speed.getKbs());
//    }

    @Test
    public void returnsNonNullTransmitDataForLoInterface() throws UnknownOperatingSystemException, NoNetworkInterfaceException, IOException {
        // given
        NetworkWatcher networkWatcher = ResourceWatcherFactory.create().getNetworkWatcher();

        // when
        var data = ((NetworkWatcherLinux)networkWatcher).getInterfaceTransmittedData("lo");

        // then
        System.out.println(data.getB());
        assertNotNull(data.getB());
    }

    @Test
    public void returnsNotNullReceiveDataForLoInterface() throws UnknownOperatingSystemException, NoNetworkInterfaceException, IOException {
        // given
        NetworkWatcher networkWatcher = ResourceWatcherFactory.create().getNetworkWatcher();

        // when
        var data = ((NetworkWatcherLinux)networkWatcher).getInterfaceReceivedData("lo");

        // then
        assertNotNull(data.getB());
    }
}
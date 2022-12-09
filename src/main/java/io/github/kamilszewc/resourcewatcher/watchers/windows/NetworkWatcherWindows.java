package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.core.Bandwidth;
import io.github.kamilszewc.resourcewatcher.exceptions.NoNetworkInterfaceException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.NetworkWatcher;

import java.io.IOException;
import java.util.List;

public class NetworkWatcherWindows implements NetworkWatcher {
    @Override
    public List<String> getListOfInterfaces() throws IOException {
        return null;
    }

    @Override
    public Bandwidth getInterfaceReceiveSpeed(String interfaceName) throws NoNetworkInterfaceException {
        return null;
    }

    @Override
    public Bandwidth getInterfaceTransmitSpeed(String interfaceName) throws NoNetworkInterfaceException {
        return null;
    }

}

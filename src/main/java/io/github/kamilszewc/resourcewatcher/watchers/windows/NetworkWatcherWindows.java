package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.core.Bandwidth;
import io.github.kamilszewc.resourcewatcher.exceptions.NoNetworkInterfaceException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.NetworkWatcher;

public class NetworkWatcherWindows implements NetworkWatcher {
    @Override
    public Bandwidth getInterfaceReceiveSpeed(String interfaceName) throws NoNetworkInterfaceException {
        return null;
    }

    @Override
    public Bandwidth getInterfaceTransmitSpeed(String interfaceName) throws NoNetworkInterfaceException {
        return null;
    }

}

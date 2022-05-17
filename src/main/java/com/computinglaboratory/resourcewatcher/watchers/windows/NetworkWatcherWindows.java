package com.computinglaboratory.resourcewatcher.watchers.windows;

import com.computinglaboratory.resourcewatcher.core.Bandwidth;
import com.computinglaboratory.resourcewatcher.exceptions.NoNetworkInterfaceException;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.NetworkWatcher;

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

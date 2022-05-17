package com.computinglaboratory.resourcewatcher.watchers.interfaces;

import com.computinglaboratory.resourcewatcher.core.Bandwidth;
import com.computinglaboratory.resourcewatcher.exceptions.NoNetworkInterfaceException;

import java.io.IOException;

public interface NetworkWatcher {
    public abstract Bandwidth getInterfaceReceiveSpeed(String interfaceName) throws NoNetworkInterfaceException, IOException;

    public abstract Bandwidth getInterfaceTransmitSpeed(String interfaceName) throws NoNetworkInterfaceException, IOException;
}

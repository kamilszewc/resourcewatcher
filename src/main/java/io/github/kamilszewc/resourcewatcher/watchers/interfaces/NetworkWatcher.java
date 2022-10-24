package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.core.Bandwidth;
import io.github.kamilszewc.resourcewatcher.exceptions.NoNetworkInterfaceException;

import java.io.IOException;

public interface NetworkWatcher {
    public abstract Bandwidth getInterfaceReceiveSpeed(String interfaceName) throws NoNetworkInterfaceException, IOException;

    public abstract Bandwidth getInterfaceTransmitSpeed(String interfaceName) throws NoNetworkInterfaceException, IOException;
}

package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.core.Bandwidth;
import io.github.kamilszewc.resourcewatcher.exceptions.NoNetworkInterfaceException;

import java.io.IOException;

/**
 * The class allows to get an information about the network interfaces in the system.
 */
public interface NetworkWatcher {
    Bandwidth getInterfaceReceiveSpeed(String interfaceName) throws NoNetworkInterfaceException, IOException;

    Bandwidth getInterfaceTransmitSpeed(String interfaceName) throws NoNetworkInterfaceException, IOException;
}

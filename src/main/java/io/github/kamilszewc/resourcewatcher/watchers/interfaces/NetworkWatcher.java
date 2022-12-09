package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import io.github.kamilszewc.resourcewatcher.core.Bandwidth;
import io.github.kamilszewc.resourcewatcher.exceptions.NoNetworkInterfaceException;

import java.io.IOException;
import java.util.List;

/**
 * The class allows to get an information about the network interfaces in the system.
 */
public interface NetworkWatcher {

    /**
     * Returns a list of network interfaces
     * @return list of network interfaces
     * @throws IOException
     */
    List<String> getListOfInterfaces() throws IOException;

    /**
     * Returns receive speed of given network interface
     * @param interfaceName the name of the network interface
     * @return Bandwidth object
     * @throws NoNetworkInterfaceException
     * @throws IOException
     */
    Bandwidth getInterfaceReceiveSpeed(String interfaceName) throws NoNetworkInterfaceException, IOException, InterruptedException;

    /**
     * Returns transmit speed of given network interface
     * @param interfaceName the name of the network interface
     * @return Bandwidth object
     * @throws NoNetworkInterfaceException
     * @throws IOException
     */
    Bandwidth getInterfaceTransmitSpeed(String interfaceName) throws NoNetworkInterfaceException, IOException, InterruptedException;
}

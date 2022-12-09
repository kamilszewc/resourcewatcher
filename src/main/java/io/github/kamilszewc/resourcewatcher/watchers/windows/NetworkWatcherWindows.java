package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.core.Bandwidth;
import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.exceptions.NoNetworkInterfaceException;
import io.github.kamilszewc.resourcewatcher.exceptions.NotImplementedException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.NetworkWatcher;

import java.io.IOException;
import java.util.List;

public class NetworkWatcherWindows implements NetworkWatcher {
    @Override
    public List<String> getListOfInterfaces() throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public Bandwidth getInterfaceReceiveSpeed(String interfaceName) throws NoNetworkInterfaceException {
        throw new NotImplementedException();
    }

    @Override
    public Bandwidth getInterfaceTransmitSpeed(String interfaceName) throws NoNetworkInterfaceException {
        throw new NotImplementedException();
    }

    @Override
    public Memory getInterfaceReceivedData(String interfaceName) throws NoNetworkInterfaceException, IOException {
        throw new NotImplementedException();
    }

    @Override
    public Memory getInterfaceTransmittedData(String interfaceName) throws NoNetworkInterfaceException, IOException {
        throw new NotImplementedException();
    }

}

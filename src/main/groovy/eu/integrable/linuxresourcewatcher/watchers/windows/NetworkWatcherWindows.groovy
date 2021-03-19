package eu.integrable.linuxresourcewatcher.watchers.windows

import eu.integrable.linuxresourcewatcher.core.Bandwidth
import eu.integrable.linuxresourcewatcher.core.Report
import eu.integrable.linuxresourcewatcher.exceptions.NoNetworkInterfaceException
import eu.integrable.linuxresourcewatcher.watchers.NetworkWatcher

class NetworkWatcherWindows implements NetworkWatcher {

    @Override
    Report<Bandwidth> getInterfaceReceiveSpeed(String interfaceName) throws NoNetworkInterfaceException {
        return null
    }

    @Override
    Report<Bandwidth> getInterfaceTransmitSpeed(String interfaceName) throws NoNetworkInterfaceException {
        return null
    }
}

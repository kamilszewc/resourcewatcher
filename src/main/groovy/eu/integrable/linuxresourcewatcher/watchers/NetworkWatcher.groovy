package eu.integrable.linuxresourcewatcher.watchers

import eu.integrable.linuxresourcewatcher.core.Bandwidth
import eu.integrable.linuxresourcewatcher.core.Report
import eu.integrable.linuxresourcewatcher.exceptions.NoNetworkInterfaceException

interface NetworkWatcher {

    Report<Bandwidth> getInterfaceReceiveSpeed(String interfaceName) throws NoNetworkInterfaceException

    Report<Bandwidth> getInterfaceTransmitSpeed(String interfaceName) throws NoNetworkInterfaceException
}

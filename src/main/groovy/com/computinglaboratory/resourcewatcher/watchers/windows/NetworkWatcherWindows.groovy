package com.computinglaboratory.resourcewatcher.watchers.windows


import com.computinglaboratory.resourcewatcher.core.Bandwidth
import com.computinglaboratory.resourcewatcher.core.Report
import com.computinglaboratory.resourcewatcher.watchers.interfaces.NetworkWatcher
import com.computinglaboratory.resourcewatcher.exceptions.NoNetworkInterfaceException

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

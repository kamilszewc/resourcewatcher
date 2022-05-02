package com.computinglaboratory.linuxresourcewatcher.watchers.windows


import com.computinglaboratory.linuxresourcewatcher.core.Bandwidth
import com.computinglaboratory.linuxresourcewatcher.core.Report
import com.computinglaboratory.linuxresourcewatcher.watchers.NetworkWatcher

class NetworkWatcherWindows implements NetworkWatcher {

    @Override
    Report<Bandwidth> getInterfaceReceiveSpeed(String interfaceName) throws com.computinglaboratory.linuxresourcewatcher.exceptions.NoNetworkInterfaceException {
        return null
    }

    @Override
    Report<Bandwidth> getInterfaceTransmitSpeed(String interfaceName) throws com.computinglaboratory.linuxresourcewatcher.exceptions.NoNetworkInterfaceException {
        return null
    }
}

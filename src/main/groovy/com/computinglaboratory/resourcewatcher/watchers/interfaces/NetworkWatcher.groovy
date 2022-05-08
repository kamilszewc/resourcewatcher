package com.computinglaboratory.resourcewatcher.watchers.interfaces


import com.computinglaboratory.resourcewatcher.core.Bandwidth
import com.computinglaboratory.resourcewatcher.core.Report
import com.computinglaboratory.resourcewatcher.exceptions.NoNetworkInterfaceException

interface NetworkWatcher {

    Report<Bandwidth> getInterfaceReceiveSpeed(String interfaceName) throws NoNetworkInterfaceException

    Report<Bandwidth> getInterfaceTransmitSpeed(String interfaceName) throws NoNetworkInterfaceException
}

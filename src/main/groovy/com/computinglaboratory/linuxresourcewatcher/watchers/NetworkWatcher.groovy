package com.computinglaboratory.linuxresourcewatcher.watchers


import com.computinglaboratory.linuxresourcewatcher.core.Bandwidth
import com.computinglaboratory.linuxresourcewatcher.core.Report

interface NetworkWatcher {

    Report<Bandwidth> getInterfaceReceiveSpeed(String interfaceName) throws com.computinglaboratory.linuxresourcewatcher.exceptions.NoNetworkInterfaceException

    Report<Bandwidth> getInterfaceTransmitSpeed(String interfaceName) throws com.computinglaboratory.linuxresourcewatcher.exceptions.NoNetworkInterfaceException
}

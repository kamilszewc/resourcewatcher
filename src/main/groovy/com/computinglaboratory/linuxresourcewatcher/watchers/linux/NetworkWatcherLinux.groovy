package com.computinglaboratory.linuxresourcewatcher.watchers.linux


import com.computinglaboratory.linuxresourcewatcher.core.Bandwidth
import com.computinglaboratory.linuxresourcewatcher.core.ProcessCommand
import com.computinglaboratory.linuxresourcewatcher.core.Report
import com.computinglaboratory.linuxresourcewatcher.watchers.NetworkWatcher

class NetworkWatcherLinux implements NetworkWatcher {

    private Long getInterfaceProcNetDevInfo(String interfaceName, int idx) throws com.computinglaboratory.linuxresourcewatcher.exceptions.NoNetworkInterfaceException {
        def value = new ProcessCommand("cat /proc/net/dev").by {
            def lines = it.split("\n").collect()
            def line = lines.stream()
                    .filter({ line -> line.split(":")[0].strip().equals(interfaceName) })
                    .findAny()
            if (line.isPresent()) {
                return Long.valueOf(line.get().strip().replaceAll("\\s+", " ").split(" ")[idx])
            } else {
                throw new com.computinglaboratory.linuxresourcewatcher.exceptions.NoNetworkInterfaceException(interfaceName);
            }
        }
        return value
    }

    @Override
    Report<Bandwidth> getInterfaceReceiveSpeed(String interfaceName) throws com.computinglaboratory.linuxresourcewatcher.exceptions.NoNetworkInterfaceException {
        def bytesFirst = getInterfaceProcNetDevInfo(interfaceName,1)
        def timeFirst = System.currentTimeMillis()
        def bytesSecond = getInterfaceProcNetDevInfo(interfaceName,1)
        def timeSecond = System.currentTimeMillis()

        def speed = Double.valueOf(bytesSecond - bytesFirst) * 1000 / (timeSecond - timeFirst)

        return new Report<>(new Bandwidth(speed))
    }

    @Override
    Report<Bandwidth> getInterfaceTransmitSpeed(String interfaceName) throws com.computinglaboratory.linuxresourcewatcher.exceptions.NoNetworkInterfaceException {
        def bytesFirst = getInterfaceProcNetDevInfo(interfaceName,9)
        def timeFirst = System.currentTimeMillis()
        def bytesSecond = getInterfaceProcNetDevInfo(interfaceName,9)
        def timeSecond = System.currentTimeMillis()

        def speed = Double.valueOf(bytesSecond - bytesFirst) * 1000 / (timeSecond - timeFirst)

        return new Report<>(new Bandwidth(speed))
    }
}

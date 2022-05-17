package com.computinglaboratory.resourcewatcher.watchers.linux;

import com.computinglaboratory.resourcewatcher.core.Bandwidth;
import com.computinglaboratory.resourcewatcher.core.ProcessCommand;
import com.computinglaboratory.resourcewatcher.exceptions.NoNetworkInterfaceException;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.NetworkWatcher;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class NetworkWatcherLinux implements NetworkWatcher {
    private Long getInterfaceProcNetDevInfo(final String interfaceName, final int idx) throws NoNetworkInterfaceException, IOException {

        String result = ProcessCommand.call("cat /proc/net/dev");
        List<String> lines = Arrays.stream(result.split("\n")).collect(Collectors.toList());
        Optional<String> line = lines.stream()
                .filter(l -> l.split(":")[0].strip().equals(interfaceName))
                .findAny();

        if (line.isPresent()) {
            return Long.valueOf(line.get().strip().replaceAll("\\s+", " ").split(" ")[idx]);

        } else {
            throw new NoNetworkInterfaceException(interfaceName);
        }
    }

    @Override
    public Bandwidth getInterfaceReceiveSpeed(String interfaceName) throws NoNetworkInterfaceException, IOException {
        Long bytesFirst = getInterfaceProcNetDevInfo(interfaceName, 1);
        long timeFirst = System.currentTimeMillis();
        Long bytesSecond = getInterfaceProcNetDevInfo(interfaceName, 1);
        long timeSecond = System.currentTimeMillis();

        Double speed = Double.valueOf(bytesSecond - bytesFirst) * 1000 / (timeSecond - timeFirst);

        return new Bandwidth(speed);
    }

    @Override
    public Bandwidth getInterfaceTransmitSpeed(String interfaceName) throws NoNetworkInterfaceException, IOException {
        Long bytesFirst = getInterfaceProcNetDevInfo(interfaceName, 9);
        long timeFirst = System.currentTimeMillis();
        Long bytesSecond = getInterfaceProcNetDevInfo(interfaceName, 9);
        long timeSecond = System.currentTimeMillis();

        Double speed = Double.valueOf(bytesSecond - bytesFirst) * 1000 / (timeSecond - timeFirst);

        return new Bandwidth(speed);
    }

}

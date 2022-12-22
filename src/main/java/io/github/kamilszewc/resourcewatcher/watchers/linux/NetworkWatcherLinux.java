package io.github.kamilszewc.resourcewatcher.watchers.linux;

import io.github.kamilszewc.resourcewatcher.core.Bandwidth;
import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.core.CommandCaller;
import io.github.kamilszewc.resourcewatcher.exceptions.NoNetworkInterfaceException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.NetworkWatcher;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * NetworkWatcher class - Linux specialization
 */
public class NetworkWatcherLinux implements NetworkWatcher {
    private Long getInterfaceProcNetDevInfo(final String interfaceName, final int idx) throws NoNetworkInterfaceException, IOException {

        String result = CommandCaller.call("cat /proc/net/dev");
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
    public List<String> getListOfInterfaces() throws IOException {

        String result = CommandCaller.call("cat /proc/net/dev");
        List<String> lines = Arrays.stream(result.split("\n")).collect(Collectors.toList());

        return lines.stream()
                .filter(line -> line.contains(":"))
                .map(line -> line.split(":")[0].strip())
                .collect(Collectors.toList());
    }

    /**
     * Returns receive speed of given network interface
     * @param interfaceName the name of the network interface
     * @return Bandwidth object
     * @throws NoNetworkInterfaceException if there is no specified network interface
     * @throws IOException if can not obtain information from os
     * @throws InterruptedException if method call interrupted
     */
    public Bandwidth getInterfaceReceiveSpeed(String interfaceName) throws NoNetworkInterfaceException, IOException, InterruptedException {
        Long bytesFirst = getInterfaceProcNetDevInfo(interfaceName, 1);
        long timeFirst = System.currentTimeMillis();
        Thread.sleep(100);
        Long bytesSecond = getInterfaceProcNetDevInfo(interfaceName, 1);
        long timeSecond = System.currentTimeMillis();

        Double speed = Double.valueOf(bytesSecond - bytesFirst) * 1000 / (timeSecond - timeFirst);

        return new Bandwidth(speed);
    }

    /**
     * Returns transmit speed of given network interface
     * @param interfaceName the name of the network interface
     * @return Bandwidth object
     * @throws NoNetworkInterfaceException if there is no specified network interface
     * @throws IOException if can not obtain information from os
     * @throws InterruptedException if method call interrupted
     */
    public Bandwidth getInterfaceTransmitSpeed(String interfaceName) throws NoNetworkInterfaceException, IOException, InterruptedException {
        Long bytesFirst = getInterfaceProcNetDevInfo(interfaceName, 9);
        long timeFirst = System.currentTimeMillis();
        Thread.sleep(100);
        Long bytesSecond = getInterfaceProcNetDevInfo(interfaceName, 9);
        long timeSecond = System.currentTimeMillis();

        Double speed = Double.valueOf(bytesSecond - bytesFirst) * 1000 / (timeSecond - timeFirst);

        return new Bandwidth(speed);
    }

    /**
     * Returns receive data size of network interface
     * @param interfaceName the name of the network interface
     * @return Memory object
     * @throws NoNetworkInterfaceException if there is no specified network interface
     * @throws IOException if can not obtain information from os
     */
    public Memory getInterfaceReceivedData(String interfaceName) throws NoNetworkInterfaceException, IOException {
        Long bytes = getInterfaceProcNetDevInfo(interfaceName, 1);
        return new Memory(bytes);
    }

    /**
     * Returns transmitted data size of network interface
     * @param interfaceName the name of the network interface
     * @return Memory object
     * @throws NoNetworkInterfaceException if there is no specified network interface
     * @throws IOException if can not obtain information from os
     */
    public Memory getInterfaceTransmittedData(String interfaceName) throws NoNetworkInterfaceException, IOException {
        Long bytes = getInterfaceProcNetDevInfo(interfaceName, 9);
        return new Memory(bytes);
    }

}

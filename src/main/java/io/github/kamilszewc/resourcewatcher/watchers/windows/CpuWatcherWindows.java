package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.core.CommandCaller;
import io.github.kamilszewc.resourcewatcher.core.CpuInfo;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.CpuWatcher;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CpuWatcher - Windows specialization
 */
public class CpuWatcherWindows implements CpuWatcher {

    /**
     * Constructor
     */
    public CpuWatcherWindows() {}

    private List<String> getWmicInfo(String variable) throws IOException {
        String result = CommandCaller.call("wmic cpu get " + variable);
        return Arrays.stream(result.split("\n"))
                .filter(line -> !line.isBlank())
                .map(String::trim)
                .skip(1)
                .collect(Collectors.toList());
    }

    @Override
    public CpuInfo getCpuInfo() throws IOException {

        String name = getWmicInfo("name").get(0);
        String vendor = getWmicInfo("manufacturer").get(0);
        Float frequency = Float.valueOf(getWmicInfo("currentclockspeed").get(0));
        Integer numberOfSockets = getWmicInfo("name").size();
        Integer numberOfCoresPerSocket = Integer.valueOf(getWmicInfo("numberofcores").get(0));
        Integer numberOfCores = numberOfSockets * numberOfCoresPerSocket;
        Integer numberOfThreadsPerCore = Integer.valueOf(getWmicInfo("threadcount").get(0));
        Integer numberOfThreads = numberOfCores * numberOfThreadsPerCore;
        Integer numberOfThreadsPerSocket = numberOfCoresPerSocket * numberOfThreadsPerCore;

        return CpuInfo.builder()
                .name(name)
                .vendor(vendor)
                .frequency(frequency)
                .numberOfSockets(numberOfSockets)
                .numberOfCores(numberOfCores)
                .numberOfThreads(numberOfThreads)
                .numberOfCoresPerSocket(numberOfCoresPerSocket)
                .numberOfThreadsPerSocket(numberOfThreadsPerSocket)
                .numberOfThreadsPerCore(numberOfThreadsPerCore)
                .build();
    }
}

package com.computinglaboratory.resourcewatcher.watchers.linux;

import com.computinglaboratory.resourcewatcher.core.CommandCaller;
import com.computinglaboratory.resourcewatcher.core.CpuInfo;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.CpuWatcher;

import java.io.IOException;
import java.util.Map;

/**
 * CpuWatcher - Linux specialization
 */
public class CpuWatcherLinux implements CpuWatcher {

    /**
     * Constructor
     */
    public CpuWatcherLinux() {}

    private String getLsCpuInfo(String variable) throws IOException {
        String result = CommandCaller.call("lscpu", Map.of("LANG", "C"));
        String[] lines = result.split("\n");

        for (String line : lines) {
            String[] element = line.split(":");
            if (element[0].trim().equals(variable)) {
                return element[1].trim();
            }
        }

        return null;
    }

    private String getCatCpuInfo(String variable) throws IOException {
        String result = CommandCaller.call("cat /proc/cpuinfo");
        String[] lines = result.split("\n");

        for (String line : lines) {
            String[] element = line.split(":");
            if (element[0].trim().equals(variable)) {
                return element[1].trim();
            }
        }

        return null;
    }

    @Override
    public CpuInfo getCpuInfo() throws IOException {

        Integer numberOfSockets = getLsCpuInfo("Socket(s)").equals("-")
                ? Integer.valueOf(getLsCpuInfo("Cluster(s)"))
                : Integer.valueOf(getLsCpuInfo("Socket(s)"));

        Integer numberOfCoresPerSocket = getLsCpuInfo("Core(s) per socket") == null
                ? Integer.valueOf(getLsCpuInfo("Core(s) per cluster"))
                : Integer.valueOf(getLsCpuInfo("Core(s) per socket"));

        Integer numberOfThreadsPerCore = Integer.valueOf(getLsCpuInfo("Thread(s) per core"));

        Integer numberOfCores = numberOfSockets * numberOfCoresPerSocket;

        Integer numberOfThreads = numberOfCores * numberOfThreadsPerCore;

        Integer numberOfThreadsPerSocket = numberOfThreads / numberOfSockets;

        Float frequency = Float.valueOf(getCatCpuInfo("cpu MHz"));

        return CpuInfo.builder()
                .name(getLsCpuInfo("Model name"))
                .vendor(getLsCpuInfo("Vendor ID"))
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

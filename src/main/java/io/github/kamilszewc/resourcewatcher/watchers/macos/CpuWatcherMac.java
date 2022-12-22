package io.github.kamilszewc.resourcewatcher.watchers.macos;

import io.github.kamilszewc.resourcewatcher.core.CpuInfo;
import io.github.kamilszewc.resourcewatcher.core.CommandCaller;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.CpuWatcher;

import java.io.IOException;

/**
 * CpuWatcher - MacOS specialization
 */
public class CpuWatcherMac implements CpuWatcher {

    private String getSysCtlInfo(String variable) throws IOException {
        String result = CommandCaller.call("sysctl " + variable);
        String[] split = result.split(": ");
        try {
            return split[1].trim();
        } catch (Exception ex) {
            throw new IOException("Wrong command: sysctl " + variable);
        }
    }

    @Override
    public CpuInfo getCpuInfo() throws IOException {

        String name = getSysCtlInfo("machdep.cpu.brand_string");

        String vendor = "";
        if (name.startsWith("Apple")) {
            vendor = "Apple";
        } else {
            vendor = getSysCtlInfo("machdep.cpu.vendor");
        }

        int numberOfCoresPerSocket = Integer.valueOf(getSysCtlInfo("machdep.cpu.cores_per_package"));
        int numberOfCores = Integer.valueOf(getSysCtlInfo("machdep.cpu.core_count"));
        int numberOfThreads = Integer.valueOf(getSysCtlInfo("machdep.cpu.thread_count"));
        int numberOfSockets = Integer.valueOf(getSysCtlInfo("hw.packages"));
        int numberOfThreadsPerSocket = numberOfThreads / numberOfSockets;
        int numberOfThreadsPerCore = numberOfThreadsPerSocket / numberOfCores;

        Float frequency;
        if (name.startsWith("Apple M")) {
            frequency = 3200.0f;
        } else {
            frequency = Float.valueOf(getSysCtlInfo("hw.cpufrequency")) / 1000;
        }

        return CpuInfo.builder()
                .name(name)
                .vendor(vendor)
                .numberOfCores(numberOfCores)
                .numberOfThreads(numberOfThreads)
                .numberOfThreadsPerSocket(numberOfThreadsPerSocket)
                .numberOfCoresPerSocket(numberOfCoresPerSocket)
                .numberOfSockets(numberOfSockets)
                .numberOfThreadsPerCore(numberOfThreadsPerCore)
                .frequency(frequency)
                .build();
    }
}
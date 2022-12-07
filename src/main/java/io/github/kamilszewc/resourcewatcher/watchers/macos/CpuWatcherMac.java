package io.github.kamilszewc.resourcewatcher.watchers.macos;

import io.github.kamilszewc.resourcewatcher.core.CpuInfo;
import io.github.kamilszewc.resourcewatcher.core.ProcessCommand;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.CpuWatcher;

import java.io.IOException;

public class CpuWatcherMac implements CpuWatcher {

    private String getSysCtlInfo(String variable) throws IOException {
        String result = ProcessCommand.call("sysctl " + variable);
        String[] split = result.split(": ");
        return split[1].trim();
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

        int frequency = Integer.valueOf(getSysCtlInfo("hw.tbfrequency"));


        CpuInfo cpuInfo = CpuInfo.builder()
                .name(name)
                .vendor(vendor)
                .numberOfCores(numberOfCores)
                .numberOfThreads(numberOfThreads)
                .numberOfThreadsPerSocket(numberOfThreadsPerSocket)
                .numberOfCoresPerSocket(numberOfCoresPerSocket)
                .numberOfSockets(numberOfSockets)
                .frequency(frequency)
                .build();

        return cpuInfo;
    }
}
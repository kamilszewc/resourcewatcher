package com.computinglaboratory.resourcewatcher.watchers.windows;

import com.computinglaboratory.resourcewatcher.core.CommandCaller;
import com.computinglaboratory.resourcewatcher.core.Memory;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.RamWatcher;

import java.io.IOException;
import java.util.Arrays;

/**
 * RamWatcher class - Windows specialization
 */
public class RamWatcherWindows implements RamWatcher {

    /**
     * Constructor
     */
    public RamWatcherWindows() {}

    private String getWmicInfo(String variable) throws IOException {
        String result = CommandCaller.call("wmic os get " + variable);
        return Arrays.stream(result.split("\n"))
                .filter(line -> !line.isBlank())
                .map(String::trim)
                .skip(1)
                .findFirst()
                .get();
    }

    @Override
    public Memory getTotalMemory() throws IOException {
        long memory = Long.parseLong(getWmicInfo("totalvisiblememorysize"));
        return new Memory(memory * 1024);
    }

    @Override
    public Memory getFreeMemory() throws IOException {
        long memory = Long.parseLong(getWmicInfo("freephysicalmemory"));
        return new Memory(memory * 1024);
    }

    @Override
    public Memory getAvailableMemory() throws IOException {
        long memory = Long.parseLong(getWmicInfo("freephysicalmemory"));
        return new Memory(memory * 1024);
    }

}

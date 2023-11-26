package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.core.CommandCaller;
import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.RamWatcher;

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

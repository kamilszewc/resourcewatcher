package io.github.kamilszewc.resourcewatcher.watchers.linux;

import io.github.kamilszewc.resourcewatcher.core.CommandCaller;
import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.RamWatcher;

import java.io.IOException;

/**
 * RamWatcher class - Linux specialization
 */
public class RamWatcherLinux implements RamWatcher {

    /**
     * Constructor
     */
    public RamWatcherLinux() {}

    @Override
    public Memory getTotalMemory() throws IOException {

        String result = CommandCaller.call("cat /proc/meminfo");
        String[] lines = result.split("\n");
        for (String line : lines) {
            if (line.split(":")[0].equals("MemTotal")) {
                String[] lineElements = line.split(" ");
                Long memory = Long.valueOf(lineElements[lineElements.length - 2]);

                return new Memory(memory * 1024);
            }
        }

        throw new IOException();
    }

    @Override
    public Memory getFreeMemory() throws IOException {

        String result = CommandCaller.call("cat /proc/meminfo");
        String[] lines = result.split("\n");
        for (String line : lines) {
            if (line.split(":")[0].equals("MemFree")) {
                String[] lineElements = line.split(" ");
                Long memory = Long.valueOf(lineElements[lineElements.length - 2]);
                return new Memory(memory * 1024);
            }
        }

        throw new IOException();
    }

    @Override
    public Memory getAvailableMemory() throws IOException {

        String result = CommandCaller.call("cat /proc/meminfo");
        String[] lines = result.split("\n");
        for (String line : lines) {
            if (line.split(":")[0].equals("MemAvailable")) {
                String[] lineElements = line.split(" ");
                Long memory = Long.valueOf(lineElements[lineElements.length - 2]);
                return new Memory(memory * 1024);
            }
        }

        throw new IOException();
    }


    /**
     * Returns buffers memory
     * @return buffers memory
     * @throws IOException if can not get information from os
     */
    public Memory getBuffers() throws IOException {

        String result = CommandCaller.call("cat /proc/meminfo");
        String[] lines = result.split("\n");
        for (String line : lines) {
            if (line.split(":")[0].equals("Buffers")) {
                String[] lineElements = line.split(" ");
                Long memory = Long.valueOf(lineElements[lineElements.length - 2]);
                return new Memory(memory * 1024);
            }
        }

        throw new IOException();
    }

    /**
     * Returns cached memory
     * @return cached memory
     * @throws IOException if can not get information from os
     */
    public Memory getCachedMemory() throws IOException {

        String result = CommandCaller.call("cat /proc/meminfo");
        String[] lines = result.split("\n");
        for (String line : lines) {
            if (line.split(":")[0].equals("Cached")) {
                String[] lineElements = line.split(" ");
                Long memory = Long.valueOf(lineElements[lineElements.length - 2]);
                return new Memory(memory * 1024);
            }
        }

        throw new IOException();
    }
}

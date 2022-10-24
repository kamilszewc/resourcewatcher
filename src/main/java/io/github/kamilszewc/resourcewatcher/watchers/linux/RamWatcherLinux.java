package io.github.kamilszewc.resourcewatcher.watchers.linux;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.core.ProcessCommand;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.RamWatcher;

import java.io.IOError;
import java.io.IOException;

public class RamWatcherLinux implements RamWatcher {
    @Override
    public Memory getTotalMemory() throws IOError, IOException {

        String result = ProcessCommand.call("cat /proc/meminfo");
        String[] lines = result.split("\n");
        for (String line : lines) {
            if (line.split(":")[0].equals("MemTotal")) {
                String[] lineElements = line.split(" ");
                Long memory = Long.valueOf(lineElements[lineElements.length - 2]);

                System.out.println(memory);

                return new Memory(memory);
            }
        }

        throw new IOException();
    }

    @Override
    public Memory getFreeMemory() throws IOError, IOException {

        String result = ProcessCommand.call("cat /proc/meminfo");
        String[] lines = result.split("\n");
        for (String line : lines) {
            if (line.split(":")[0].equals("MemFree")) {
                String[] lineElements = line.split(" ");
                Long memory = Long.valueOf(lineElements[lineElements.length - 2]);
                return new Memory(memory);
            }
        }

        throw new IOException();
    }

    @Override
    public Memory getAvailableMemory() throws IOError, IOException {

        String result = ProcessCommand.call("cat /proc/meminfo");
        String[] lines = result.split("\n");
        for (String line : lines) {
            if (line.split(":")[0].equals("MemAvailable")) {
                String[] lineElements = line.split(" ");
                Long memory = Long.valueOf(lineElements[lineElements.length - 2]);
                return new Memory(memory);
            }
        }

        throw new IOException();
    }

    @Override
    public Memory getBuffers() throws IOError, IOException {

        String result = ProcessCommand.call("cat /proc/meminfo");
        String[] lines = result.split("\n");
        for (String line : lines) {
            if (line.split(":")[0].equals("Buffers")) {
                String[] lineElements = line.split(" ");
                Long memory = Long.valueOf(lineElements[lineElements.length - 2]);
                return new Memory(memory);
            }
        }

        throw new IOException();
    }

    @Override
    public Memory getCachedMemory() throws IOError, IOException {

        String result = ProcessCommand.call("cat /proc/meminfo");
        String[] lines = result.split("\n");
        for (String line : lines) {
            if (line.split(":")[0].equals("Cached")) {
                String[] lineElements = line.split(" ");
                Long memory = Long.valueOf(lineElements[lineElements.length - 2]);
                return new Memory(memory);
            }
        }

        throw new IOException();
    }

}

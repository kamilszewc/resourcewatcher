package com.computinglaboratory.resourcewatcher.watchers.linux;

import com.computinglaboratory.resourcewatcher.core.Memory;
import com.computinglaboratory.resourcewatcher.core.ProcessCommand;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.RamWatcher;

import java.io.IOError;
import java.io.IOException;

public class RamWatcherLinux implements RamWatcher {
    @Override
    public Memory getTotalMemory() throws IOError, IOException {

        String result = ProcessCommand.call("cat /proc/meminfo");
        String[] lines = result.split("\n");
        for (String line : lines) {
            if (line.split(":")[0].equals("MemTotal")) {
                Long memory = Long.valueOf(line.split(" ")[-2]);
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
                Long memory = Long.valueOf(line.split(" ")[-2]);
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
                Long memory = Long.valueOf(line.split(" ")[-2]);
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
                Long memory = Long.valueOf(line.split(" ")[-2]);
                return new Memory(memory);
            }
        }

        throw new IOException();
    }

    @Override
    public Memory getCached() throws IOError, IOException {

        String result = ProcessCommand.call("cat /proc/meminfo");
        String[] lines = result.split("\n");
        for (String line : lines) {
            if (line.split(":")[0].equals("Cached")) {
                Long memory = Long.valueOf(line.split(" ")[-2]);
                return new Memory(memory);
            }
        }

        throw new IOException();
    }

}

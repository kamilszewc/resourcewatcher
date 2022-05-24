package com.computinglaboratory.resourcewatcher.watchers.macos;

import com.computinglaboratory.resourcewatcher.core.Memory;
import com.computinglaboratory.resourcewatcher.core.ProcessCommand;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.RamWatcher;

import java.io.IOError;
import java.io.IOException;

public class RamWatcherMac implements RamWatcher {
    @Override
    public Memory getTotalMemory() throws IOError, IOException {

        String result = ProcessCommand.call("sysctl hw.memsize");
        String[] split = result.split(": ");
        Long value = Long.valueOf(split[1].trim());
        return new Memory(value / 1024);
    }

    @Override
    public Memory getFreeMemory() throws IOError, IOException {

        throw new IOException();
    }

    @Override
    public Memory getAvailableMemory() throws IOError, IOException {


        throw new IOException();
    }

    @Override
    public Memory getBuffers() throws IOError, IOException {


        throw new IOException();
    }

    @Override
    public Memory getCachedMemory() throws IOError, IOException {


        throw new IOException();
    }

}

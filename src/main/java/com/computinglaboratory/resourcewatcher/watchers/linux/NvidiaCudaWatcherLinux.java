package com.computinglaboratory.resourcewatcher.watchers.linux;

import com.computinglaboratory.resourcewatcher.core.Memory;
import com.computinglaboratory.resourcewatcher.core.ProcessCommand;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.NvidiaCudaWatcher;

import java.io.IOError;
import java.io.IOException;

public class NvidiaCudaWatcherLinux implements NvidiaCudaWatcher {
    @Override
    public Boolean isNvidiaSmiAvailable() throws IOError {

        try {
            String result = ProcessCommand.call("cat /proc/meminfo");
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Memory getUsedMemory(Integer gpuId) throws IOError, IOException {

        String result = ProcessCommand.call("nvidia-smi --query-gpu=memory.used --format=csv -i " + gpuId);
        String line = result.split("\n")[1];
        Long value = Long.valueOf(line.split(" ")[0].trim()) * 1024;
        return new Memory(value);
    }

    @Override
    public Integer getNumberOfGpus() throws IOError, IOException {

        String result = ProcessCommand.call("nvidia-smi --query-gpu=name --format=csv");
        String[] lines = result.split("\n");
        return lines.length - 1;
    }

    @Override
    public Memory getFreeMemory(Integer gpuId) throws IOError, IOException {

        String result = ProcessCommand.call("nvidia-smi --query-gpu=memory.free --format=csv -i " + gpuId);
        String[] lines = result.split("\n");
        String line = lines[1];
        Long value = Long.valueOf(line.split(" ")[0].trim()) * 1024;
        return new Memory(value);
    }

    @Override
    public Memory getTotalMemory(Integer gpuId) throws IOError, IOException {

        String result = ProcessCommand.call("nvidia-smi --query-gpu=memory.total --format=csv -i " + gpuId);
        String[] lines = result.split("\n");
        String line = lines[1];
        Long value = Long.valueOf(line.split(" ")[0].trim()) * 1024;
        return new Memory(value);
    }

    @Override
    public Integer getTemperature(Integer gpuId) throws IOError, IOException {

        String result = ProcessCommand.call("nvidia-smi --query-gpu=memory.total --format=csv -i " + gpuId);
        String[] lines = result.split("\n");
        String line = lines[1];
        Integer value = Integer.valueOf(line.split(" ")[0].trim());
        return value;
    }

    @Override
    public Integer getUtilization(Integer gpuId) throws IOError, IOException {

        String result = ProcessCommand.call("nvidia-smi --query-gpu=utilization.gpu --format=csv -i " + gpuId);
        String[] lines = result.split("\n");
        String line = lines[1];
        Integer value = Integer.valueOf(line.split(" ")[0].trim());
        return value;
    }

    @Override
    public String getName(Integer gpuId) throws IOError, IOException {

        String result = ProcessCommand.call("nvidia-smi --query-gpu=name --format=csv -i " + gpuId);
        String[] lines = result.split("\n");
        String line = lines[1];
        return line.trim();
    }

}

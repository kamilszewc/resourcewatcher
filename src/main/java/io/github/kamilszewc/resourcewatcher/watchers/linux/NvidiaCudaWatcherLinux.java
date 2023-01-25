package io.github.kamilszewc.resourcewatcher.watchers.linux;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.core.CommandCaller;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.NvidiaCudaWatcher;

import java.io.IOException;

/**
 * NvidiaCudaWatcher class - Linux specialization
 */
public class NvidiaCudaWatcherLinux implements NvidiaCudaWatcher {

    /**
     * Constructor
     */
    public NvidiaCudaWatcherLinux() {}
    @Override
    public Memory getUsedMemory(Integer gpuId) throws IOException {

        String result = CommandCaller.call("nvidia-smi --query-gpu=memory.used --format=csv -i " + gpuId);
        String line = result.split("\n")[1];
        Long value = Long.valueOf(line.split(" ")[0].trim()) * 1024;
        return new Memory(value * 1024);
    }

    @Override
    public Integer getNumberOfGpus() throws IOException {

        String result = CommandCaller.call("nvidia-smi --query-gpu=name --format=csv");
        String[] lines = result.split("\n");
        return lines.length - 1;
    }

    @Override
    public Memory getFreeMemory(Integer gpuId) throws IOException {

        String result = CommandCaller.call("nvidia-smi --query-gpu=memory.free --format=csv -i " + gpuId);
        String[] lines = result.split("\n");
        String line = lines[1];
        Long value = Long.valueOf(line.split(" ")[0].trim()) * 1024;
        return new Memory(value * 1024);
    }

    @Override
    public Memory getTotalMemory(Integer gpuId) throws IOException {

        String result = CommandCaller.call("nvidia-smi --query-gpu=memory.total --format=csv -i " + gpuId);
        String[] lines = result.split("\n");
        String line = lines[1];
        Long value = Long.valueOf(line.split(" ")[0].trim()) * 1024;
        return new Memory(value * 1024);
    }

    @Override
    public Integer getTemperature(Integer gpuId) throws IOException {

        String result = CommandCaller.call("nvidia-smi --query-gpu=memory.total --format=csv -i " + gpuId);
        String[] lines = result.split("\n");
        String line = lines[1];
        return Integer.valueOf(line.split(" ")[0].trim());
    }

    @Override
    public Integer getUtilization(Integer gpuId) throws IOException {

        String result = CommandCaller.call("nvidia-smi --query-gpu=utilization.gpu --format=csv -i " + gpuId);
        String[] lines = result.split("\n");
        String line = lines[1];
        return Integer.valueOf(line.split(" ")[0].trim());
    }

    @Override
    public String getName(Integer gpuId) throws IOException {

        String result = CommandCaller.call("nvidia-smi --query-gpu=name --format=csv -i " + gpuId);
        String[] lines = result.split("\n");
        String line = lines[1];
        return line.trim();
    }

}

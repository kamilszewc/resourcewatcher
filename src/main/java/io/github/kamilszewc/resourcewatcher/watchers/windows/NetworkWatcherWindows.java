package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.core.CommandCaller;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.NetworkWatcher;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * NetworkWatcher class - Windows specialization
 */
public class NetworkWatcherWindows implements NetworkWatcher {

    private List<String> getWmicInfo(String variable) throws IOException {
        String result = CommandCaller.call("wmic nic get " + variable);
        return Arrays.stream(result.split("\n"))
                .filter(line -> !line.isBlank())
                .map(String::trim)
                .skip(1)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getListOfInterfaces() throws IOException {
        return getWmicInfo("name");
    }

}

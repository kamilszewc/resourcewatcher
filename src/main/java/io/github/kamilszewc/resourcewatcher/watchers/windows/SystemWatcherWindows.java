package io.github.kamilszewc.resourcewatcher.watchers.windows;

import io.github.kamilszewc.resourcewatcher.core.CommandCaller;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.SystemWatcher;

import java.io.IOException;
import java.util.Arrays;

/**
 * SystemWatcher class - Windows implementation
 */
public class SystemWatcherWindows implements SystemWatcher {

    /**
     * Constructor
     */
    SystemWatcherWindows() {
    }

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
    public Integer getNumberOfProcesses() throws IOException {
        return Integer.valueOf(getWmicInfo("numberofprocesses"));
    }

    @Override
    public String getKernelReleaseVersion() throws IOException {
        return getWmicInfo("version");
    }

    @Override
    public String getKernelVersion() throws IOException {
        return getWmicInfo("version");
    }

    @Override
    public String getNodeName() throws IOException {
        return getWmicInfo("csname");
    }

    @Override
    public String getSystemName() throws IOException {
        return getWmicInfo("caption");
    }

    @Override
    public String getSystemVersion() throws IOException {
        return getWmicInfo("version");
    }

    @Override
    public String getSystemId() throws IOException {
        return "Windows";
    }

}

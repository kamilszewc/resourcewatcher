package io.github.kamilszewc.resourcewatcher.watchers.macos;

import io.github.kamilszewc.resourcewatcher.core.CommandCaller;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.SystemWatcher;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * SystemWatcher class - MacOS specialization
 */
public class SystemWatcherMac implements SystemWatcher {

    /**
     * Constructor
     */
    SystemWatcherMac() {
    }

    @Override
    public Integer getNumberOfProcesses() throws IOException {

        String result = CommandCaller.call("ps -e");
        String[] lines = result.split("\n");
        return lines.length - 1;
    }

    @Override
    public String getKernelReleaseVersion() throws IOException {
        return CommandCaller.call("uname -r").trim();
    }

    public String getKernelVersion() throws IOException {
        return CommandCaller.call("uname -v").trim();
    }

    @Override
    public String getNodeName() throws IOException {
        return CommandCaller.call("uname -n").trim();
    }

    @Override
    public String getSystemName() throws IOException {
        return getSystemIdentificationData().get("ProductName");
    }

    @Override
    public String getSystemVersion() throws IOException {
        return getSystemIdentificationData().get("ProductVersion");
    }

    @Override
    public String getSystemId() throws IOException {
        return getSystemIdentificationData().get("ProductName");
    }

    /**
     * Return the system identification data
     * @return map of key-value records identifying os
     * @throws IOException if information from os can not be achieved
     */
    public Map<String, String> getSystemIdentificationData() throws IOException {
        Map<String, String> identificationData = new HashMap<>();
        String data = CommandCaller.call("sw_vers");
        String[] lines = data.split("\n");
        for (String line : lines) {
            String[] info = line.split(":");
            identificationData.put(info[0].trim(), info[1].trim());
        }
        return identificationData;
    }
}

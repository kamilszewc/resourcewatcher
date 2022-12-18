package io.github.kamilszewc.resourcewatcher.watchers.macos;

import io.github.kamilszewc.resourcewatcher.core.ProcessCommand;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.SystemWatcher;

import java.io.IOError;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SystemWatcherMac implements SystemWatcher {
    @Override
    public Integer getNumberOfProcesses() throws IOError, IOException {

        String result = ProcessCommand.call("ps -e");
        String[] lines = result.split("\n");
        return lines.length - 1;
    }

    @Override
    public String getKernelReleaseVersion() throws IOException {
        return ProcessCommand.call("uname -r").trim();
    }

    public String getKernelVersion() throws IOException {
        return ProcessCommand.call("uname -v").trim();
    }

    @Override
    public String getNodeName() throws IOException {
        return ProcessCommand.call("uname -n").trim();
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

    public Map<String, String> getSystemIdentificationData() throws IOException {
        Map<String, String> identificationData = new HashMap<>();
        String data = ProcessCommand.call("sw_vers");
        String[] lines = data.split("\n");
        for (String line : lines) {
            String[] info = line.split(":");
            identificationData.put(info[0].trim(), info[1].trim());
        }
        return identificationData;
    }
}

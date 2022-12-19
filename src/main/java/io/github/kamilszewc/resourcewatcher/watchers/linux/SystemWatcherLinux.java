package io.github.kamilszewc.resourcewatcher.watchers.linux;

import io.github.kamilszewc.resourcewatcher.core.ProcessCommand;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.SystemWatcher;

import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class SystemWatcherLinux implements SystemWatcher {
    @Override
    public Integer getNumberOfProcesses() throws IOError, IOException {

        String result = ProcessCommand.call("ps -eo nlwp");
        String[] lines = result.split("\n");
        int sum = 0;
        for (int i=1; i< lines.length; i++) {
            String line = lines[i];
            sum += Integer.valueOf(line.trim());
        }

        return sum;
    }

    public String getKernelReleaseVersion() throws IOException {
        return ProcessCommand.call("uname -r").trim();
    }

    public String getKernelVersion() throws IOException {
        return ProcessCommand.call("uname -v").trim();
    }

    public String getNodeName() throws IOException {
        return ProcessCommand.call("uname -n").trim();
    }

    public String getSystemName() throws IOException {
        return getSystemIdentificationData().get("NAME");
    }

    public String getSystemVersion() throws IOException {
        return getSystemIdentificationData().get("VERSION");
    }

    public String getSystemId() throws IOException {
        return getSystemIdentificationData().get("ID");
    }

    public Map<String, String> getSystemIdentificationData() throws IOException {
        Path filePath;
        if (Files.exists(Path.of("/etc/os-release"))) {
            filePath = Path.of("/etc/os-release");
        } else if (Files.exists(Path.of("/usr/lib/os-release"))) {
            filePath = Path.of("/usr/lib/os-release");
        } else {
            throw new IOException("Can not get information from os-release file");
        }

        Map<String, String> keyValue = new HashMap<>();

        String data = Files.readString(filePath);
        String[] dataLines = data.split("\n");
        for (String line : dataLines) {
            String[] var = line.split("=");
            String key = var[0].trim();
            String value = var[1].substring(1, var[1].length()-1);
            keyValue.put(key, value);
        }

        return keyValue;
    }
}

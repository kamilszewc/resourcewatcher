package io.github.kamilszewc.resourcewatcher.watchers.macos;

import io.github.kamilszewc.resourcewatcher.core.ProcessCommand;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.SystemWatcher;

import java.io.IOError;
import java.io.IOException;

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
        return null;
    }

    @Override
    public String getSystemVersion() throws IOException {
        return null;
    }

    @Override
    public String getSystemId() throws IOException {
        return null;
    }
}

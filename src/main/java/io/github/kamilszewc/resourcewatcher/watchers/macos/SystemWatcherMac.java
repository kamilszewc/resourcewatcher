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
}

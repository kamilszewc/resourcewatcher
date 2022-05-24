package com.computinglaboratory.resourcewatcher.watchers.macos;

import com.computinglaboratory.resourcewatcher.core.ProcessCommand;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.SystemProcessesWatcher;

import java.io.IOError;
import java.io.IOException;

public class SystemProcessesWatcherMac implements SystemProcessesWatcher {
    @Override
    public Integer getNumberOfProcesses() throws IOError, IOException {

        String result = ProcessCommand.call("ps -e");
        String[] lines = result.split("\n");
        return lines.length - 1;
    }
}

package io.github.kamilszewc.resourcewatcher.watchers.linux;

import io.github.kamilszewc.resourcewatcher.core.ProcessCommand;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.SystemProcessesWatcher;

import java.io.IOError;
import java.io.IOException;

public class SystemProcessesWatcherLinux implements SystemProcessesWatcher {
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

}

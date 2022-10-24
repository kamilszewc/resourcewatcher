package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import java.io.IOError;
import java.io.IOException;

public interface SystemProcessesWatcher {
    public abstract Integer getNumberOfProcesses() throws IOError, IOException;
}

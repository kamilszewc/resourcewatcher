package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import java.io.IOError;
import java.io.IOException;

/**
 * The class allows to get an information about the system processes in the system.
 */
public interface SystemProcessesWatcher {
    Integer getNumberOfProcesses() throws IOError, IOException;
}

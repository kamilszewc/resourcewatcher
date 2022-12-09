package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import java.io.IOError;
import java.io.IOException;

/**
 * The class allows to get an information about the system processes in the system.
 */
public interface SystemProcessesWatcher {

    /**
     * Gets the number of processes running in the OS
     * @return number of processes
     * @throws IOError
     * @throws IOException
     */
    Integer getNumberOfProcesses() throws IOError, IOException;
}

package io.github.kamilszewc.resourcewatcher.watchers.interfaces;

import java.io.IOException;

/**
 * The class allows to get an information about the system processes in the system.
 */
public interface SystemWatcher {

    /**
     * Gets the number of processes running in the OS
     * @return number of processes
     * @throws IOException if can not get information from os
     */
    Integer getNumberOfProcesses() throws IOException;

    /**
     * Returns the kernel release version
     * @return kernel release version
     * @throws IOException if can not get information from os
     */
    String getKernelReleaseVersion() throws IOException;

    /**
     * Returns the kernel version
     * @return kernel release version
     * @throws IOException if can not get information from os
     */
    String getKernelVersion() throws IOException;

    /**
     * Returns node name
     * @return node name
     * @throws IOException if can not get information from os
     */
    String getNodeName() throws IOException;

    /**
     * Returns system name
     * @return system name
     * @throws IOException if can not get information from os
     */
    String getSystemName() throws IOException;

    /**
     * Returns system version
     * @return system version
     * @throws IOException if can not get information from os
     */
    String getSystemVersion() throws IOException;

    /**
     * Returns system id
     * @return system id
     * @throws IOException if can not get information from os
     */
    String getSystemId() throws IOException;
}

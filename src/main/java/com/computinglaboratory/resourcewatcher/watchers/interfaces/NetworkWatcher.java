package com.computinglaboratory.resourcewatcher.watchers.interfaces;

import java.io.IOException;
import java.util.List;

/**
 * The class allows to get an information about the network interfaces in the system.
 */
public interface NetworkWatcher {

    /**
     * Returns a list of network interfaces
     * @return list of network interfaces
     * @throws IOException if can not get information from os
     */
    List<String> getListOfInterfaces() throws IOException;
}

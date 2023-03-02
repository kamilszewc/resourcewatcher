package com.computinglaboratory.resourcewatcher;

import com.computinglaboratory.resourcewatcher.exceptions.UnknownOperatingSystemException;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.ResourceWatcher;
import com.computinglaboratory.resourcewatcher.watchers.linux.ResourceWatcherLinux;
import com.computinglaboratory.resourcewatcher.watchers.macos.ResourceWatcherMac;
import com.computinglaboratory.resourcewatcher.watchers.windows.ResourceWatcherWindows;
import org.apache.commons.lang3.SystemUtils;

/**
 * The factory class for automatic detection of OS and producing the right ResourceWatcher object
 */
public class ResourceWatcherFactory {

    /**
     * Constructor
     */
    public ResourceWatcherFactory() {}

    /**
     * Creates the ResourceWatcher object for detected OS
     * @return ResourceWatcher object
     * @throws UnknownOperatingSystemException if operating system is unknown
     */
    public static ResourceWatcher create() throws UnknownOperatingSystemException {

        if (SystemUtils.IS_OS_LINUX) {
            return new ResourceWatcherLinux();

        } else if (SystemUtils.IS_OS_MAC) {
            return new ResourceWatcherMac();

        } else if (SystemUtils.IS_OS_WINDOWS) {
            return new ResourceWatcherWindows();

        } else {
            throw new UnknownOperatingSystemException();
        }

    }

    /**
     * Creates the ResourceWatcher object for detected OS
     * @return ResourceWatcher object
     * @throws UnknownOperatingSystemException if operating system is unknown
     */
    public static ResourceWatcher createResourceWatcher() throws UnknownOperatingSystemException {
        return create();
    }


    /**
     * Returns the type of operating system.
     * @return OperatingSystem object
     */
    public static ResourceWatcher.OperatingSystem getOperatingSystem() {
        return ResourceWatcher.getOperatingSystem();
    }

}

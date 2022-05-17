package com.computinglaboratory.resourcewatcher;

import com.computinglaboratory.resourcewatcher.exceptions.UnknownOperatingSystemException;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.ResourceWatcher;
import com.computinglaboratory.resourcewatcher.watchers.linux.ResourceWatcherLinux;
import com.computinglaboratory.resourcewatcher.watchers.macos.ResourceWatcherMac;
import com.computinglaboratory.resourcewatcher.watchers.windows.ResourceWatcherWindows;
import org.apache.commons.lang3.SystemUtils;

public class ResourceWatcherFactory {
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

    public static ResourceWatcher createResourceWatcher() throws UnknownOperatingSystemException {
        return create();
    }

}

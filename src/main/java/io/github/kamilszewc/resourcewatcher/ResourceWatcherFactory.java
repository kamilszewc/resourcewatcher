package io.github.kamilszewc.resourcewatcher;

import io.github.kamilszewc.resourcewatcher.exceptions.UnknownOperatingSystemException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.ResourceWatcher;
import io.github.kamilszewc.resourcewatcher.watchers.linux.ResourceWatcherLinux;
import io.github.kamilszewc.resourcewatcher.watchers.macos.ResourceWatcherMac;
import io.github.kamilszewc.resourcewatcher.watchers.windows.ResourceWatcherWindows;
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

package eu.integrable.linuxresourcewatcher.watchers

import eu.integrable.linuxresourcewatcher.watchers.linux.SystemDiskWatcherLinux
import eu.integrable.linuxresourcewatcher.watchers.windows.SystemDiskWatcherWindows

public class SystemDiskWatcherGenerator {

    static SystemDiskWatcher getInstance(String platform) {

        if (platform == "windows")
            return new SystemDiskWatcherWindows();
        else
            return new SystemDiskWatcherLinux();
    }
}

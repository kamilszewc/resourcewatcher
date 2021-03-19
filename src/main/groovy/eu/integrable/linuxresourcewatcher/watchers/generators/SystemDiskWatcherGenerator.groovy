package eu.integrable.linuxresourcewatcher.watchers.generators

import eu.integrable.linuxresourcewatcher.watchers.DiskWatcher
import eu.integrable.linuxresourcewatcher.watchers.linux.DiskWatcherLinux
import eu.integrable.linuxresourcewatcher.watchers.windows.DiskWatcherWindows

public class SystemDiskWatcherGenerator {

    static DiskWatcher getInstance(String platform) {

        if (platform == "windows")
            return new DiskWatcherWindows();
        else
            return new DiskWatcherLinux();
    }
}

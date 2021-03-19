package eu.integrable.linuxresourcewatcher.watchers.generators

import eu.integrable.linuxresourcewatcher.watchers.RamWatcher
import eu.integrable.linuxresourcewatcher.watchers.linux.RamWatcherLinux
import eu.integrable.linuxresourcewatcher.watchers.windows.RamWatcherWindows

public class SystemRamWatcherGenerator {

    static RamWatcher getInstance(String platform) {

        if (platform == "windows")
            return new RamWatcherWindows();
        else
            return new RamWatcherLinux();
    }
}

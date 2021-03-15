package eu.integrable.linuxresourcewatcher.watchers

import eu.integrable.linuxresourcewatcher.watchers.linux.SystemRamWatcherLinux
import eu.integrable.linuxresourcewatcher.watchers.windows.SystemRamWatcherWindows

public class SystemRamWatcherGenerator {

    static SystemRamWatcher getInstance(String platform) {

        if (platform == "windows")
            return new SystemRamWatcherWindows();
        else
            return new SystemRamWatcherLinux();
    }
}

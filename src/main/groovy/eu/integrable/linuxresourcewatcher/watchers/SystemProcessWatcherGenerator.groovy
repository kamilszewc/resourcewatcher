package eu.integrable.linuxresourcewatcher.watchers;

import eu.integrable.linuxresourcewatcher.watchers.linux.SystemProcessesWatcherLinux;
import eu.integrable.linuxresourcewatcher.watchers.windows.SystemProcessesWatcherWindows;

public class SystemProcessWatcherGenerator {

    static SystemProcessesWatcher getInstance(String platform) {

        if (platform == "windows")
            return new SystemProcessesWatcherWindows();
        else
            return new SystemProcessesWatcherLinux();
    }
}

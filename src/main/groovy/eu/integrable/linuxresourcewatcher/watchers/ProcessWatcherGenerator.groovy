package eu.integrable.linuxresourcewatcher.watchers

import eu.integrable.linuxresourcewatcher.watchers.linux.ProcessWatcherLinux
import eu.integrable.linuxresourcewatcher.watchers.windows.ProcessWatcherWindows

public class ProcessWatcherGenerator {

    static ProcessWatcher getInstance(String platform) {

        if (platform == "windows")
            return new ProcessWatcherWindows();
        else
            return new ProcessWatcherLinux();
    }
}

package eu.integrable.linuxresourcewatcher.watchers

import eu.integrable.linuxresourcewatcher.watchers.linux.NvidiaCudaWatcherLinux
import eu.integrable.linuxresourcewatcher.watchers.windows.NvidiaCudaWatcherWindows

public class NvidiaCudaWatcherGenerator {

    static NvidiaCudaWatcher getInstance(String platform) {

        if (platform == "windows")
            return new NvidiaCudaWatcherWindows();
        else
            return new NvidiaCudaWatcherLinux();
    }
}

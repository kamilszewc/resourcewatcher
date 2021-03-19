package eu.integrable.linuxresourcewatcher.watchers.generators

import eu.integrable.linuxresourcewatcher.watchers.NvidiaCudaWatcher
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

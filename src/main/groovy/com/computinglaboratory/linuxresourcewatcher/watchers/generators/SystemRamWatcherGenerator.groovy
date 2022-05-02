package com.computinglaboratory.linuxresourcewatcher.watchers.generators

import com.computinglaboratory.linuxresourcewatcher.watchers.RamWatcher
import com.computinglaboratory.linuxresourcewatcher.watchers.linux.RamWatcherLinux
import com.computinglaboratory.linuxresourcewatcher.watchers.windows.RamWatcherWindows

public class SystemRamWatcherGenerator {

    static RamWatcher getInstance(String platform) {

        if (platform == "windows")
            return new RamWatcherWindows();
        else
            return new RamWatcherLinux();
    }
}

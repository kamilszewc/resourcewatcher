package com.computinglaboratory.linuxresourcewatcher.watchers.generators


import com.computinglaboratory.linuxresourcewatcher.watchers.DiskWatcher
import com.computinglaboratory.linuxresourcewatcher.watchers.linux.DiskWatcherLinux

public class SystemDiskWatcherGenerator {

    static DiskWatcher getInstance(String platform) {

        if (platform == "windows")
            return new com.computinglaboratory.linuxresourcewatcher.watchers.windows.DiskWatcherWindows();
        else
            return new DiskWatcherLinux();
    }
}

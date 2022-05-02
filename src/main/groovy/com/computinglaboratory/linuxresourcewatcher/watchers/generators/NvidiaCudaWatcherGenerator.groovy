package com.computinglaboratory.linuxresourcewatcher.watchers.generators

import com.computinglaboratory.linuxresourcewatcher.watchers.NvidiaCudaWatcher
import com.computinglaboratory.linuxresourcewatcher.watchers.linux.NvidiaCudaWatcherLinux
import com.computinglaboratory.linuxresourcewatcher.watchers.windows.NvidiaCudaWatcherWindows

public class NvidiaCudaWatcherGenerator {

    static NvidiaCudaWatcher getInstance(String platform) {

        if (platform == "windows")
            return new NvidiaCudaWatcherWindows();
        else
            return new NvidiaCudaWatcherLinux();
    }
}

package com.computinglaboratory.linuxresourcewatcher.watchers.generators

import com.computinglaboratory.linuxresourcewatcher.watchers.ProcessWatcher
import com.computinglaboratory.linuxresourcewatcher.watchers.linux.ProcessWatcherLinux
import com.computinglaboratory.linuxresourcewatcher.watchers.windows.ProcessWatcherWindows

public class ProcessWatcherGenerator {

    static ProcessWatcher getInstance(String platform) {

        if (platform == "windows")
            return new ProcessWatcherWindows();
        else
            return new ProcessWatcherLinux();
    }
}

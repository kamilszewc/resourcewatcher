package com.computinglaboratory.linuxresourcewatcher.watchers.generators

import com.computinglaboratory.linuxresourcewatcher.watchers.SystemProcessesWatcher;
import com.computinglaboratory.linuxresourcewatcher.watchers.linux.SystemProcessesWatcherLinux;
import com.computinglaboratory.linuxresourcewatcher.watchers.windows.SystemProcessesWatcherWindows;

public class SystemProcessWatcherGenerator {

    static SystemProcessesWatcher getInstance(String platform) {

        if (platform == "windows")
            return new SystemProcessesWatcherWindows();
        else
            return new SystemProcessesWatcherLinux();
    }
}

package eu.integrable.linuxresourcewatcher.watchers

import eu.integrable.linuxresourcewatcher.core.ProcessCommand
import eu.integrable.linuxresourcewatcher.core.Report

class NvidiaCudaWatcher {

    Report<Boolean> isNvidiaSmiAvailable() {
        try {
            def value = new ProcessCommand("nvidia-smsi").by {}
        } catch (IOException ex) {
            return new Report<>(false)
        }

        return new Report<>(true)
    }
}

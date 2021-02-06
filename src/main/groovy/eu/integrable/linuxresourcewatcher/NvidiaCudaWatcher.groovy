package eu.integrable.linuxresourcewatcher

import eu.integrable.linuxresourcewatcher.exceptions.NoProcessFoundException

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

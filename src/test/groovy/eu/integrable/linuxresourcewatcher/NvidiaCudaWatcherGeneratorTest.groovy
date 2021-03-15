package eu.integrable.linuxresourcewatcher

import eu.integrable.linuxresourcewatcher.watchers.NvidiaCudaWatcherGenerator
import eu.integrable.linuxresourcewatcher.watchers.SystemProcessWatcherGenerator
import eu.integrable.linuxresourcewatcher.watchers.SystemProcessesWatcher
import spock.lang.Specification

class NvidiaCudaWatcherGeneratorTest extends Specification {

    def "windows variant of nvidia-smi is available"() {
        given:
        def watcher = NvidiaCudaWatcherGenerator.getInstance("windows");

        when:
        def isAvailable = watcher.isNvidiaSmiAvailable()

        then:
        isAvailable == true
    }
}

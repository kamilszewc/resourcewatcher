package eu.integrable.linuxresourcewatcher

import eu.integrable.linuxresourcewatcher.exceptions.NoProcessFoundException
import spock.lang.Specification

class NvidiaCudaWatcherTest extends Specification {

    def "isNvidiaSmiAvailable gives false if nvidia-smi is not available"() {
        given:
        def cudaWatcher = new NvidiaCudaWatcher()

        when:
        def isAvailable = cudaWatcher.isNvidiaSmiAvailable()

        then:
        isAvailable.value == false
    }
}

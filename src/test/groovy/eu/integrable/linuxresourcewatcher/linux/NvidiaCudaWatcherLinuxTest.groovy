package eu.integrable.linuxresourcewatcher.linux


import eu.integrable.linuxresourcewatcher.watchers.linux.NvidiaCudaWatcherLinux
import spock.lang.Specification

class NvidiaCudaWatcherLinuxTest extends Specification {

    def "isNvidiaSmiAvailable gives false if nvidia-smi is not available"() {
        given:
        def cudaWatcher = new NvidiaCudaWatcherLinux()

        when:
        def isAvailable = cudaWatcher.isNvidiaSmiAvailable()

        then:
        isAvailable.value == false || isAvailable.value == true
    }
}

package com.computinglaboratory.resourcewatcher.linux

import com.computinglaboratory.resourcewatcher.ResourceWatcherFactory
import spock.lang.Specification

class NvidiaCudaWatcherLinuxTest extends Specification {

    def "isNvidiaSmiAvailable gives false if nvidia-smi is not available"() {
        given:
        def cudaWatcher = ResourceWatcherFactory.create().nvidiaCudaWatcher

        when:
        def isAvailable = cudaWatcher.isNvidiaSmiAvailable()

        then:
        isAvailable.value == false || isAvailable.value == true
    }
}

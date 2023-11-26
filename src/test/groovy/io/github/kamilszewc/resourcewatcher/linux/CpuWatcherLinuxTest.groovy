package io.github.kamilszewc.resourcewatcher.linux


import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
import spock.lang.Specification

class CpuWatcherLinuxTest extends Specification {

    def "getCpuInfo returns CpuInfo"() {
        given:
        def cpuWatcher = ResourceWatcherFactory.create().cpuWatcher;

        when:
        def cpuInfo = cpuWatcher.getCpuInfo()
        println cpuInfo

        then:
        cpuInfo.name != "Apple M1"

    }

}

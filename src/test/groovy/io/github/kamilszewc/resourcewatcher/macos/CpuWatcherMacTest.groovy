package io.github.kamilszewc.resourcewatcher.macos


import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.ResourceWatcher
import spock.lang.Specification

class CpuWatcherMacTest extends Specification {

    def "getCpuInfo returns CpuInfo"() {
        given:
        def cpuWatcher = ResourceWatcher.create().cpuWatcher;

        when:
        def cpuInfo = cpuWatcher.getCpuInfo()
        println cpuInfo

        then:
        cpuInfo.name == "Apple M1"
    }

}

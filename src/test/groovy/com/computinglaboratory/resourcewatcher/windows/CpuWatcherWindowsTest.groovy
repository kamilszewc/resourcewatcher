package com.computinglaboratory.resourcewatcher.windows


import com.computinglaboratory.resourcewatcher.ResourceWatcherFactory
import spock.lang.Specification

class CpuWatcherWindowsTest extends Specification {

    def "getCpuInfo returns CpuInfo"() {
        given:
        def cpuWatcher = ResourceWatcherFactory.create().cpuWatcher;

        when:
        def cpuInfo = cpuWatcher.getCpuInfo()
        println cpuInfo

        then:
        cpuInfo.name != "Apple M1"
        cpuInfo.name == "12th Gen Intel(R) Core(TM) i7-1255U"
    }

}

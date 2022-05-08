package com.computinglaboratory.resourcewatcher.macos

import com.computinglaboratory.resourcewatcher.ResourceWatcherBuilder
import spock.lang.Specification

class SystemProcessesWatcherMacTest extends Specification {

    def "gives non null number of processes report"() {
        given:
        def systemProcessesWatcher = ResourceWatcherBuilder.build().systemProcessesWatcher

        when:
        def numberOfProcesses = systemProcessesWatcher.getNumberOfProcesses()

        then:
        numberOfProcesses != null
    }
}

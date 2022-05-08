package com.computinglaboratory.resourcewatcher.linux

import com.computinglaboratory.resourcewatcher.ResourceWatcherBuilder
import spock.lang.Specification

class SystemProcessesWatcherLinuxTest extends Specification {

    def "gives non null number of processes report"() {
        given:
        def systemProcessesWatcher = ResourceWatcherBuilder.build().systemProcessesWatcher

        when:
        def numberOfProcesses = systemProcessesWatcher.getNumberOfProcesses()

        then:
        numberOfProcesses != null
    }
}

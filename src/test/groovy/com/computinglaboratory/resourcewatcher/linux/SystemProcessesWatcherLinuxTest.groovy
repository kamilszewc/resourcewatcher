package com.computinglaboratory.resourcewatcher.linux

import com.computinglaboratory.resourcewatcher.ResourceWatcherFactory
import spock.lang.Specification

class SystemProcessesWatcherLinuxTest extends Specification {

    def "gives non null number of processes report"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemProcessesWatcher

        when:
        def numberOfProcesses = systemProcessesWatcher.getNumberOfProcesses()

        then:
        numberOfProcesses != null
    }
}

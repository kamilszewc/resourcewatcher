package io.github.kamilszewc.resourcewatcher.macos


import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
import spock.lang.Specification

class SystemProcessesWatcherMacTest extends Specification {

    def "gives non null number of processes report"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemProcessesWatcher

        when:
        def numberOfProcesses = systemProcessesWatcher.getNumberOfProcesses()
        print numberOfProcesses

        then:
        numberOfProcesses != null
    }
}

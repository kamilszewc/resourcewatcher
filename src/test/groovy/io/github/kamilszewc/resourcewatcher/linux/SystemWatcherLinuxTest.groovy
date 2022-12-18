package io.github.kamilszewc.resourcewatcher.linux

import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
import spock.lang.Specification

class SystemWatcherLinuxTest extends Specification {

    def "getNumberOfProcesses is not null"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher

        when:
        def numberOfProcesses = systemProcessesWatcher.getNumberOfProcesses()
        print numberOfProcesses

        then:
        numberOfProcesses != null
    }
}

package eu.integrable.linuxresourcewatcher

import eu.integrable.linuxresourcewatcher.watchers.SystemProcessesWatcher
import spock.lang.Specification

class SystemProcessesWatcherTest extends Specification {

    def "gives non null number of processes report"() {
        given:
        def systemProcessesWatcher = new SystemProcessesWatcher()

        when:
        def numberOfProcesses = systemProcessesWatcher.getNumberOfProcesses()

        then:
        numberOfProcesses != null
    }
}

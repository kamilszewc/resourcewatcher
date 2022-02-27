package eu.integrable.linuxresourcewatcher.macos

import eu.integrable.linuxresourcewatcher.watchers.macos.SystemProcessesWatcherMac
import spock.lang.Specification

class SystemProcessesWatcherMacTest extends Specification {

    def "gives non null number of processes report"() {
        given:
        def systemProcessesWatcher = new SystemProcessesWatcherMac()

        when:
        def numberOfProcesses = systemProcessesWatcher.getNumberOfProcesses()

        then:
        numberOfProcesses != null
    }
}

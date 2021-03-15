package eu.integrable.linuxresourcewatcher.linux

import eu.integrable.linuxresourcewatcher.watchers.linux.SystemProcessesWatcherLinux
import spock.lang.Specification

class SystemProcessesWatcherLinuxTest extends Specification {

    def "gives non null number of processes report"() {
        given:
        def systemProcessesWatcher = new SystemProcessesWatcherLinux()

        when:
        def numberOfProcesses = systemProcessesWatcher.getNumberOfProcesses()

        then:
        numberOfProcesses != null
    }
}

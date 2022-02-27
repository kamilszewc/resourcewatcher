package eu.integrable.linuxresourcewatcher.macos

import eu.integrable.linuxresourcewatcher.exceptions.NoProcessFoundException
import eu.integrable.linuxresourcewatcher.watchers.macos.ProcessWatcherMac
import spock.lang.Specification

class ProcessWatcherMacTest extends Specification {

    def "gives non null process rss memory report"() {
        given:
        def processWatcher = new ProcessWatcherMac()

        when:
        def processMemory = processWatcher.getProcessResidentSetSizeMemory(1)

        then:
        processMemory != null
    }

    def "getProcessResidentSetSizeMemory rise exception when process does not exist"() {
        given:
        def processWatcher = new ProcessWatcherMac()

        when:
        def processMemory = processWatcher.getProcessResidentSetSizeMemory(1342342324)

        then:
        thrown NoProcessFoundException
    }

    def "gives non null process with children rss memory report"() {
        given:
        def processWatcher = new ProcessWatcherMac()

        when:
        def processMemory = processWatcher.getProcessResidentSetSizeWithChildrenMemory(1)

        then:
        processMemory != null
    }

    def "gives non null process vsz memory report"() {
        given:
        def processWatcher = new ProcessWatcherMac()

        when:
        def processMemory = processWatcher.getProcessVirtualMemory(1)

        then:
        processMemory != null
    }

    def "gives non null process with children vsz memory report"() {
        given:
        def processWatcher = new ProcessWatcherMac()

        when:
        def processMemory = processWatcher.getProcessVirtualWithChildrenMemory(1)

        then:
        processMemory != null
    }

    def "gives non null children tree report"() {
        given:
        def processWatcher = new ProcessWatcherMac()

        when:
        def childrenTree = processWatcher.getChildrenTree(1)

        then:
        childrenTree != null
    }

    def "getProcessCpuTime gives non null duration"() {
        given:
        def processWatcher = new ProcessWatcherMac()

        when:
        def cpuTime = processWatcher.getProcessCpuTime(1)

        then:
        cpuTime != null
    }

    def "getProcessCpuTimeWithChildren gives non null duration"() {
        given:
        def processWatcher = new ProcessWatcherMac()

        when:
        def cpuTime = processWatcher.getProcessCpuTime(1)

        then:
        cpuTime != null
    }
}

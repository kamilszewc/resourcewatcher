package eu.integrable.linuxresourcewatcher

import eu.integrable.linuxresourcewatcher.exceptions.NoProcessFoundException
import spock.lang.Specification

import java.time.Duration

class ProcessWatcherTest extends Specification {

    def "gives non null process rss memory report"() {
        given:
        def processWatcher = new ProcessWatcher()

        when:
        def processMemory = processWatcher.getProcessResidentSetSizeMemory(1)

        then:
        processMemory != null
    }

    def "getProcessResidentSetSizeMemory rise exception when process does not exist"() {
        given:
        def processWatcher = new ProcessWatcher()

        when:
        def processMemory = processWatcher.getProcessResidentSetSizeMemory(1342342324)

        then:
        thrown NoProcessFoundException
    }

    def "gives non null process with children rss memory report"() {
        given:
        def processWatcher = new ProcessWatcher()

        when:
        def processMemory = processWatcher.getProcessResidentSetSizeWithChildrenMemory(1)

        then:
        processMemory != null
    }

    def "gives non null process vsz memory report"() {
        given:
        def processWatcher = new ProcessWatcher()

        when:
        def processMemory = processWatcher.getProcessVirtualMemory(1)

        then:
        processMemory != null
    }

    def "gives non null process with children vsz memory report"() {
        given:
        def processWatcher = new ProcessWatcher()

        when:
        def processMemory = processWatcher.getProcessVirtualWithChildrenMemory(1)

        then:
        processMemory != null
    }

    def "gives non null children tree report"() {
        given:
        def processWatcher = new ProcessWatcher()

        when:
        def childrenTree = processWatcher.getChildrenTree(1)

        then:
        childrenTree != null
    }

    def "getProcessCpuTime gives non null duration"() {
        given:
        def processWatcher = new ProcessWatcher()

        when:
        def cpuTime = processWatcher.getProcessCpuTime(1)
        println cpuTime.value

        then:
        cpuTime != null
    }
}

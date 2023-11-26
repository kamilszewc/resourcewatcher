package io.github.kamilszewc.resourcewatcher.macos


import io.github.kamilszewc.resourcewatcher.exceptions.NoProcessFoundException
import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
import spock.lang.Specification

class ProcessWatcherMacTest extends Specification {

    def "gives non null process rss memory report"() {
        given:
        def processWatcher = ResourceWatcherFactory.create().processWatcher

        when:
        def processMemory = processWatcher.getProcessResidentSetSizeMemory(1)
        print processMemory.getKB()

        then:
        processMemory != null
    }

    def "getProcessResidentSetSizeMemory rise exception when process does not exist"() {
        given:
        def processWatcher = ResourceWatcherFactory.create().processWatcher

        when:
        def processMemory = processWatcher.getProcessResidentSetSizeMemory(1342342324)

        then:
        thrown NoProcessFoundException
    }

    def "gives non null process with children rss memory report"() {
        given:
        def processWatcher = ResourceWatcherFactory.create().processWatcher

        when:
        def processMemory = processWatcher.getProcessResidentSetSizeWithChildrenMemory(305)
        print processMemory.getKB()

        then:
        processMemory != null
    }

    def "gives non null process vsz memory report"() {
        given:
        def processWatcher = ResourceWatcherFactory.create().processWatcher

        when:
        def processMemory = processWatcher.getProcessVirtualMemory(305)
        print processMemory.getKB()

        then:
        processMemory != null
    }

    def "gives non null process with children vsz memory report"() {
        given:
        def processWatcher = ResourceWatcherFactory.create().processWatcher

        when:
        def processMemory = processWatcher.getProcessVirtualWithChildrenMemory(305)
        print processMemory.getKB()

        then:
        processMemory != null
    }

    def "gives non null children tree report"() {
        given:
        def processWatcher = ResourceWatcherFactory.create().processWatcher

        when:
        def childrenTree = processWatcher.getChildrenTree(1)
        print childrenTree

        then:
        childrenTree != null
    }

    def "getProcessCpuTime gives non null duration"() {
        given:
        def processWatcher = ResourceWatcherFactory.create().processWatcher

        when:
        def cpuTime = processWatcher.getProcessCpuTime(1)
        print cpuTime

        then:
        cpuTime != null
    }

    def "getProcessCpuTimeWithChildren gives non null duration"() {
        given:
        def processWatcher = ResourceWatcherFactory.create().processWatcher

        when:
        def cpuTime = processWatcher.getProcessCpuTime(1)
        print cpuTime

        then:
        cpuTime != null
    }
}

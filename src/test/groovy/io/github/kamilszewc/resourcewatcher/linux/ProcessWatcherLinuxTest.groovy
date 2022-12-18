package io.github.kamilszewc.resourcewatcher.linux


import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
import io.github.kamilszewc.resourcewatcher.exceptions.NoProcessFoundException
import io.github.kamilszewc.resourcewatcher.watchers.linux.ProcessWatcherLinux
import io.github.kamilszewc.resourcewatcher.watchers.linux.ResourceWatcherLinux
import spock.lang.Specification

class ProcessWatcherLinuxTest extends Specification {

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
        def processMemory = processWatcher.getProcessResidentSetSizeWithChildrenMemory(1)
        print processMemory.getKB()

        then:
        processMemory != null
    }

    def "gives non null process vsz memory report"() {
        given:
        def processWatcher = ResourceWatcherFactory.create().processWatcher

        when:
        def processMemory = processWatcher.getProcessVirtualMemory(1)
        print processMemory.getKB()

        then:
        processMemory != null
    }

    def "gives non null process with children vsz memory report"() {
        given:
        def processWatcher = ResourceWatcherFactory.create().processWatcher

        when:
        def processMemory = processWatcher.getProcessVirtualWithChildrenMemory(1)
        print processMemory.getKB()

        then:
        processMemory != null
    }

    def "gives non null process pss memory report"() {
        given:
        def processWatcher = new  ResourceWatcherLinux().processWatcher as ProcessWatcherLinux;

        when:
        def processMemory = processWatcher.getProcessProportionalSetSizeMemory(1);
        println  "Proportional single " + processMemory.getKB()

        def processMemoryWithChildren = processWatcher.getProcessProportionalSetSizeWithChildrenMemory(1);
        println "Proportional tree " + processMemoryWithChildren.getKB()

        processMemoryWithChildren = processWatcher.getProcessUniqueSetSizeWithChildrenMemory(1);
        println "Unique tree " + processMemoryWithChildren.getKB()

        processMemoryWithChildren = processWatcher.getProcessResidentSetSizeWithChildrenMemory(1);
        println "Resident tree " + processMemoryWithChildren.getKB()

        processMemoryWithChildren = processWatcher.getProcessVirtualWithChildrenMemory(1);
        println "Virtual tree " + processMemoryWithChildren.getKB()

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

    def "getProcessCpuTime gives non null time in sec"() {
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
        def cpuTime = processWatcher.getProcessCpuTimeWithChildren(1)
        print cpuTime

        then:
        cpuTime != null
    }
}

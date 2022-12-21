package io.github.kamilszewc.resourcewatcher.windows

import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
import io.github.kamilszewc.resourcewatcher.exceptions.NoProcessFoundException
import spock.lang.Specification

class ProcessWatcherWindowsTest extends Specification {

    def "gives non null process rss memory report"() {
        given:
        def processWatcher = ResourceWatcherFactory.create().processWatcher

        when:
        def processMemory = processWatcher.getProcessResidentSetSizeMemory(0)
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
//
//    def "gives non null process with children rss memory report"() {
//        given:
//        def processWatcher = ResourceWatcherFactory.create().processWatcher
//
//        when:
//        def processMemory = processWatcher.getProcessResidentSetSizeWithChildrenMemory(1)
//        print processMemory.getKB()
//
//        then:
//        processMemory != null
//    }
//
//    def "gives non null process vsz memory report"() {
//        given:
//        def processWatcher = ResourceWatcherFactory.create().processWatcher
//
//        when:
//        def processMemory = processWatcher.getProcessVirtualMemory(1)
//        print processMemory.getKB()
//
//        then:
//        processMemory != null
//    }
//
//    def "gives non null process with children vsz memory report"() {
//        given:
//        def processWatcher = ResourceWatcherFactory.create().processWatcher
//
//        when:
//        def processMemory = processWatcher.getProcessVirtualWithChildrenMemory(1)
//        print processMemory.getKB()
//
//        then:
//        processMemory != null
//    }
//
//
//    def "gives non null children tree report"() {
//        given:
//        def processWatcher = ResourceWatcherFactory.create().processWatcher
//
//        when:
//        def childrenTree = processWatcher.getChildrenTree(1)
//        print childrenTree
//
//        then:
//        childrenTree != null
//    }

}

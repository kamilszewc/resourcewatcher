package eu.integrable.linuxresourcewatcher

import spock.lang.Specification

class ProcessWatcherTest extends Specification {

    def "gives non null process rss memory report"() {
        given:
        def processWatcher = new ProcessWatcher()

        when:
        def processMemory = processWatcher.getProcessResidentSetSizeMemory(1)

        then:
        println processMemory.value.KB()
        processMemory != null
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
}

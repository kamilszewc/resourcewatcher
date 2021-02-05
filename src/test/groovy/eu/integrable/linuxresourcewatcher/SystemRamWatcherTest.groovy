package eu.integrable.linuxresourcewatcher

import spock.lang.*

class SystemRamWatcherTest extends Specification {

    def "gives non null total memory report"() {
        given:
        def systemRamWatcher = new SystemRamWatcher()

        when:
        def totalMemory = systemRamWatcher.getTotalMemory()

        then:
        totalMemory != null && totalMemory != 0
    }

    def "gives non null free memory report"() {
        given:
        def systemRamWatcher = new SystemRamWatcher()

        when:
        def freeMemory = systemRamWatcher.getFreeMemory()

        then:
        freeMemory != null && freeMemory != 0
    }

    def "gives non null available memory report"() {
        given:
        def systemRamWatcher = new SystemRamWatcher()

        when:
        def availableMemory = systemRamWatcher.getAvailableMemory()

        then:
        availableMemory != null && availableMemory != 0
    }

    def "gives non null cached report"() {
        given:
        def systemRamWatcher = new SystemRamWatcher()

        when:
        def buffers = systemRamWatcher.getCached()

        then:
        buffers != null && buffers != 0
    }

    def "gives non null buffers report"() {
        given:
        def systemRamWatcher = new SystemRamWatcher()

        when:
        def buffers = systemRamWatcher.getBuffers()

        then:
        buffers != null && buffers != 0
    }
}

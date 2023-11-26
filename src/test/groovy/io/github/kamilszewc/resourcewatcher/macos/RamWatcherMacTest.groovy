package io.github.kamilszewc.resourcewatcher.macos


import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
import spock.lang.Specification

class RamWatcherMacTest extends Specification {

    def "getTotalMemory is not null"() {
        given:
        def systemRamWatcher = ResourceWatcherFactory.create().ramWatcher

        when:
        def totalMemory = systemRamWatcher.getTotalMemory()
        print totalMemory.getMB()

        then:
        totalMemory != null && totalMemory != 0
    }

    def "getFreeMemory is not null"() {
        given:
        def systemRamWatcher = ResourceWatcherFactory.create().ramWatcher

        when:
        def freeMemory = systemRamWatcher.getFreeMemory()
        print freeMemory.getMB()

        then:
        freeMemory != null && freeMemory != 0
    }

    def "getAvailableMemory is not null"() {
        given:
        def systemRamWatcher = ResourceWatcherFactory.create().ramWatcher

        when:
        def availableMemory = systemRamWatcher.getAvailableMemory()
        print availableMemory.getKB()

        then:
        availableMemory != null && availableMemory != 0
    }
}

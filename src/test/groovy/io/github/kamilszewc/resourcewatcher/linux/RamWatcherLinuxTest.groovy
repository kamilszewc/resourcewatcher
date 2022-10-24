package io.github.kamilszewc.resourcewatcher.linux

import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
import spock.lang.*

class RamWatcherLinuxTest extends Specification {

    def "getTotalMemory is not null"() {
        given:
        def systemRamWatcher = ResourceWatcherFactory.create().ramWatcher

        when:
        def totalMemory = systemRamWatcher.getTotalMemory()
        print totalMemory.MB()

        then:
        totalMemory != null && totalMemory != 0
    }

    def "getFreeMemory is not null"() {
        given:
        def systemRamWatcher = ResourceWatcherFactory.create().ramWatcher

        when:
        def freeMemory = systemRamWatcher.getFreeMemory()
        print freeMemory.MB()

        then:
        freeMemory != null && freeMemory != 0
    }

    def "getAvailableMemory is not null"() {
        given:
        def systemRamWatcher = ResourceWatcherFactory.create().ramWatcher

        when:
        def availableMemory = systemRamWatcher.getAvailableMemory()
        print availableMemory.MB()

        then:
        availableMemory != null && availableMemory != 0
    }

    def "getCachedMemory is not null"() {
        given:
        def systemRamWatcher = ResourceWatcherFactory.create().ramWatcher

        when:
        def cachedMemory = systemRamWatcher.getCachedMemory()
        print cachedMemory.MB()

        then:
        cachedMemory != null && cachedMemory != 0
    }

    def "getBuffers is not null"() {
        given:
        def systemRamWatcher = ResourceWatcherFactory.create().ramWatcher

        when:
        def buffers = systemRamWatcher.getBuffers()
        print buffers.MB()

        then:
        buffers != null && buffers != 0
    }
}

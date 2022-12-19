package io.github.kamilszewc.resourcewatcher.linux

import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
import io.github.kamilszewc.resourcewatcher.watchers.linux.RamWatcherLinux
import io.github.kamilszewc.resourcewatcher.watchers.linux.SystemWatcherLinux
import spock.lang.*

class RamWatcherLinuxTest extends Specification {

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
        print availableMemory.getMB()

        then:
        availableMemory != null && availableMemory != 0
    }

    def "getBuffers is not null"() {
        given:
        def systemRamWatcher = ResourceWatcherFactory.create().ramWatcher as RamWatcherLinux

        when:
        def buffers = systemRamWatcher.getBuffers()
        print buffers.getB()

        then:
        buffers != null && buffers.b != 0
    }

    def "getCachedMemory is not null"() {
        given:
        def systemRamWatcher = ResourceWatcherFactory.create().ramWatcher as RamWatcherLinux

        when:
        def cached = systemRamWatcher.getCachedMemory()
        print cached.getB()

        then:
        cached != null && cached.b != 0
    }
}

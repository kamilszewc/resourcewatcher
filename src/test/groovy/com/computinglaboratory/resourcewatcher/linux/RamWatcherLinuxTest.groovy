package com.computinglaboratory.resourcewatcher.linux


import spock.lang.*

class RamWatcherLinuxTest extends Specification {

    def "getTotalMemory is not null"() {
        given:
        def systemRamWatcher = com.computinglaboratory.resourcewatcher.ResourceWatcherFactory.create().ramWatcher

        when:
        def totalMemory = systemRamWatcher.getTotalMemory()
        print totalMemory.getMB()

        then:
        totalMemory != null && totalMemory != 0
    }

    def "getFreeMemory is not null"() {
        given:
        def systemRamWatcher = com.computinglaboratory.resourcewatcher.ResourceWatcherFactory.create().ramWatcher

        when:
        def freeMemory = systemRamWatcher.getFreeMemory()
        print freeMemory.getMB()

        then:
        freeMemory != null && freeMemory != 0
    }

    def "getAvailableMemory is not null"() {
        given:
        def systemRamWatcher = com.computinglaboratory.resourcewatcher.ResourceWatcherFactory.create().ramWatcher

        when:
        def availableMemory = systemRamWatcher.getAvailableMemory()
        print availableMemory.getMB()

        then:
        availableMemory != null && availableMemory != 0
    }

    def "getBuffers is not null"() {
        given:
        def systemRamWatcher = com.computinglaboratory.resourcewatcher.ResourceWatcherFactory.create().ramWatcher as com.computinglaboratory.resourcewatcher.watchers.linux.RamWatcherLinux

        when:
        def buffers = systemRamWatcher.getBuffers()
        print buffers.getB()

        then:
        buffers != null && buffers.b != 0
    }

    def "getCachedMemory is not null"() {
        given:
        def systemRamWatcher = com.computinglaboratory.resourcewatcher.ResourceWatcherFactory.create().ramWatcher as com.computinglaboratory.resourcewatcher.watchers.linux.RamWatcherLinux

        when:
        def cached = systemRamWatcher.getCachedMemory()
        print cached.getB()

        then:
        cached != null && cached.b != 0
    }
}

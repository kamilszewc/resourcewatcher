package com.computinglaboratory.resourcewatcher.macos

import com.computinglaboratory.resourcewatcher.ResourceWatcherFactory
import com.computinglaboratory.resourcewatcher.exceptions.NoPartitionException
import spock.lang.Specification

class DiskWatcherMacTest extends Specification{

    def "gives non null partition available space report"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getAvailablePartitionSpace("/")

        then:
        partitionSize != null
    }

    def "getAvailablePartitionSpace rise an exception when partition does not exist"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getUsedPartitionSpace("dsffd")

        then:
        thrown NoPartitionException
    }

    def "gives non null partition used space report"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getUsedPartitionSpace("/")

        then:
        partitionSize != null
    }

    def "getUsedPartitionSpace rise an exception when partition does not exist"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getUsedPartitionSpace("dsffd")

        then:
        thrown NoPartitionException
    }

    def "gives non null list of partitions report"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitions = diskWatcher.getListOfPartitions()

        then:
        partitions != null
    }


}

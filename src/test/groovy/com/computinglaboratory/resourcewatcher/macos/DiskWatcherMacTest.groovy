package com.computinglaboratory.resourcewatcher.macos

import com.computinglaboratory.resourcewatcher.ResourceWatcherFactory
import com.computinglaboratory.resourcewatcher.exceptions.NoPartitionException
import spock.lang.Specification

class DiskWatcherMacTest extends Specification{

    def "getUsablePartitionSpace rise an exception when partition does not exist"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getUsablePartitionSpace("dsffd")

        then:
        thrown NoPartitionException
    }

    def "getFreePartitionSpace"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getFreePartitionSpace("/")
        print partitionSize.GB()

        then:
        partitionSize != null
    }

    def "getTotalPartitionSpace"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getTotalPartitionSpace("/")
        print partitionSize.GB()

        then:
        partitionSize != null
    }

    def "getUsablePartitionSpace"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getUsablePartitionSpace("/")
        print partitionSize.value.GB()

        then:
        partitionSize != null
    }

    def "Gives list of partitions"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitions = diskWatcher.getListOfPartitions()
        print partitions

        then:
        partitions != null
    }

}

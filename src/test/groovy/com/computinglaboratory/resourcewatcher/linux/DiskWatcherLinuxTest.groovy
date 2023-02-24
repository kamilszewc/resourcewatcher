package com.computinglaboratory.resourcewatcher.linux


import spock.lang.Specification

class DiskWatcherLinuxTest extends Specification{

    def "getFreePartitionSpace"() {
        given:
        def diskWatcher = com.computinglaboratory.resourcewatcher.ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getFreePartitionSpace("/")
        print partitionSize.getGB()

        then:
        partitionSize != null
    }

    def "getFreePartitionSpace NoPartitionException"() {
        given:
        def diskWatcher = com.computinglaboratory.resourcewatcher.ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getFreePartitionSpace("dsffd")

        then:
        thrown com.computinglaboratory.resourcewatcher.exceptions.NoPartitionException
    }

    def "getUsablePartitionSpace"() {
        given:
        def diskWatcher = com.computinglaboratory.resourcewatcher.ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getUsablePartitionSpace("/")
        print partitionSize.getGB()

        then:
        partitionSize != null
    }

    def "getUsablePartitionSpace NoPartitionException"() {
        given:
        def diskWatcher = com.computinglaboratory.resourcewatcher.ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getUsablePartitionSpace("dsffd")

        then:
        thrown com.computinglaboratory.resourcewatcher.exceptions.NoPartitionException
    }

    def "getTotalPartitionSpace"() {
        given:
        def diskWatcher = com.computinglaboratory.resourcewatcher.ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getTotalPartitionSpace("/")
        print partitionSize.getGB()

        then:
        partitionSize != null
    }

    def "getTotalPartitionSpace NoPartitionException"() {
        given:
        def diskWatcher = com.computinglaboratory.resourcewatcher.ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getTotalPartitionSpace("dsffd")

        then:
        thrown com.computinglaboratory.resourcewatcher.exceptions.NoPartitionException
    }


    def "getListOfPartitions"() {
        given:
        def diskWatcher = com.computinglaboratory.resourcewatcher.ResourceWatcherFactory.create().diskWatcher

        when:
        def partitions = diskWatcher.getListOfPartitions()
        print partitions

        then:
        partitions != null
    }


}

package io.github.kamilszewc.resourcewatcher.macos


import io.github.kamilszewc.resourcewatcher.exceptions.NoPartitionException
import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
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
        print partitionSize.getGB()

        then:
        partitionSize != null
    }

    def "getTotalPartitionSpace"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getTotalPartitionSpace("/")
        print partitionSize.getGB()

        then:
        partitionSize != null
    }

    def "getUsablePartitionSpace"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getUsablePartitionSpace("/")
        print partitionSize.getGB()

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

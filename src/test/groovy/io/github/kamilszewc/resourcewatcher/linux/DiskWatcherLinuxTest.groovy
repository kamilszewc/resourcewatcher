package io.github.kamilszewc.resourcewatcher.linux


import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
import io.github.kamilszewc.resourcewatcher.exceptions.NoPartitionException
import spock.lang.Specification

class DiskWatcherLinuxTest extends Specification{

    def "getFreePartitionSpace"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getFreePartitionSpace("/")
        print partitionSize.GB()

        then:
        partitionSize != null
    }

    def "getFreePartitionSpace NoPartitionException"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getFreePartitionSpace("dsffd")

        then:
        thrown NoPartitionException
    }

    def "getUsablePartitionSpace"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getUsablePartitionSpace("/")
        print partitionSize.GB()

        then:
        partitionSize != null
    }

    def "getUsablePartitionSpace NoPartitionException"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getUsablePartitionSpace("dsffd")

        then:
        thrown NoPartitionException
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

    def "getTotalPartitionSpace NoPartitionException"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getTotalPartitionSpace("dsffd")

        then:
        thrown NoPartitionException
    }


    def "getListOfPartitions"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitions = diskWatcher.getListOfPartitions()
        print partitions

        then:
        partitions != null
    }


}

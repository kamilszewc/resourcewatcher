package io.github.kamilszewc.resourcewatcher.windows


import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
import io.github.kamilszewc.resourcewatcher.exceptions.NoPartitionException
import spock.lang.Specification

class DiskWatcherWindowsTest extends Specification{

    def "getFreePartitionSpace"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getFreePartitionSpace("C:")
        print partitionSize.getGB()

        then:
        partitionSize != null
    }

    def "getFreePartitionSpace NoPartitionException"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getFreePartitionSpace("sdsfds")

        then:
        thrown NoPartitionException
    }

    def "getUsablePartitionSpace"() {
        given:
        def diskWatcher = ResourceWatcherFactory.create().diskWatcher

        when:
        def partitionSize = diskWatcher.getUsablePartitionSpace("C:")
        print partitionSize.getGB()

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
        def partitionSize = diskWatcher.getTotalPartitionSpace("C:")
        print partitionSize.getGB()

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

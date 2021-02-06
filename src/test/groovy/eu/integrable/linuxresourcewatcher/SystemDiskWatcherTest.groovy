package eu.integrable.linuxresourcewatcher

import eu.integrable.linuxresourcewatcher.exceptions.NoPartitionException
import eu.integrable.linuxresourcewatcher.watchers.SystemDiskWatcher
import spock.lang.Specification

class SystemDiskWatcherTest extends Specification{

    def "gives non null partition available space report"() {
        given:
        def diskWatcher = new SystemDiskWatcher()

        when:
        def partitionSize = diskWatcher.getAvailablePartitionSpace("/")

        then:
        partitionSize != null
    }

    def "getAvailablePartitionSpace rise an exception when partition does not exist"() {
        given:
        def diskWatcher = new SystemDiskWatcher()

        when:
        def partitionSize = diskWatcher.getUsedPartitionSpace("dsffd")

        then:
        thrown NoPartitionException
    }

    def "gives non null partition used space report"() {
        given:
        def diskWatcher = new SystemDiskWatcher()

        when:
        def partitionSize = diskWatcher.getUsedPartitionSpace("/")

        then:
        partitionSize != null
    }

    def "getUsedPartitionSpace rise an exception when partition does not exist"() {
        given:
        def diskWatcher = new SystemDiskWatcher()

        when:
        def partitionSize = diskWatcher.getUsedPartitionSpace("dsffd")

        then:
        thrown NoPartitionException
    }

    def "gives non null list of partitions report"() {
        given:
        def diskWatcher = new SystemDiskWatcher()

        when:
        def partitions = diskWatcher.getListOfPartitions()

        then:
        partitions != null
    }


}

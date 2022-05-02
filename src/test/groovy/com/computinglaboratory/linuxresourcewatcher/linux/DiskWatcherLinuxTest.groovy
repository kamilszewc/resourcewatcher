package com.computinglaboratory.linuxresourcewatcher.linux

import com.computinglaboratory.linuxresourcewatcher.exceptions.NoPartitionException
import com.computinglaboratory.linuxresourcewatcher.watchers.linux.DiskWatcherLinux
import spock.lang.Specification

class DiskWatcherLinuxTest extends Specification{

    def "gives non null partition available space report"() {
        given:
        def diskWatcher = new DiskWatcherLinux()

        when:
        def partitionSize = diskWatcher.getAvailablePartitionSpace("/")

        then:
        partitionSize != null
    }

    def "getAvailablePartitionSpace rise an exception when partition does not exist"() {
        given:
        def diskWatcher = new DiskWatcherLinux()

        when:
        def partitionSize = diskWatcher.getUsedPartitionSpace("dsffd")

        then:
        thrown NoPartitionException
    }

    def "gives non null partition used space report"() {
        given:
        def diskWatcher = new DiskWatcherLinux()

        when:
        def partitionSize = diskWatcher.getUsedPartitionSpace("/")

        then:
        partitionSize != null
    }

    def "getUsedPartitionSpace rise an exception when partition does not exist"() {
        given:
        def diskWatcher = new DiskWatcherLinux()

        when:
        def partitionSize = diskWatcher.getUsedPartitionSpace("dsffd")

        then:
        thrown NoPartitionException
    }

    def "gives non null list of partitions report"() {
        given:
        def diskWatcher = new DiskWatcherLinux()

        when:
        def partitions = diskWatcher.getListOfPartitions()

        then:
        partitions != null
    }


}

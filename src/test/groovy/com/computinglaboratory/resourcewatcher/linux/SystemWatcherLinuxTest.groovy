package com.computinglaboratory.resourcewatcher.linux

import com.computinglaboratory.resourcewatcher.ResourceWatcherFactory
import com.computinglaboratory.resourcewatcher.watchers.linux.SystemWatcherLinux
import spock.lang.Specification

class SystemWatcherLinuxTest extends Specification {

    def "getNumberOfProcesses is not null"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher

        when:
        def numberOfProcesses = systemProcessesWatcher.getNumberOfProcesses()
        print numberOfProcesses

        then:
        numberOfProcesses != null
    }

    def "getKernelReleaseVersion is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher as SystemWatcherLinux

        when:
        def kernelReleaseVersion = systemProcessesWatcher.getKernelReleaseVersion()
        print kernelReleaseVersion

        then:
        kernelReleaseVersion != ""
    }

    def "getKernelVersion is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher as SystemWatcherLinux

        when:
        def kernelVersion = systemProcessesWatcher.getKernelVersion()
        print kernelVersion

        then:
        kernelVersion != ""
    }

    def "getNodeName is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher as SystemWatcherLinux

        when:
        def nodeName = systemProcessesWatcher.getNodeName()
        print nodeName

        then:
        nodeName != ""
    }

    def "getSystemIdentificationData is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher as SystemWatcherLinux

        when:
        def systemIdentificationData = systemProcessesWatcher.getSystemIdentificationData()
        print systemIdentificationData

        then:
        systemIdentificationData != ""
    }

    def "getSystemName is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher as SystemWatcherLinux

        when:
        def systemName = systemProcessesWatcher.getSystemName()
        print systemName

        then:
        systemName != ""
    }

    def "getSystemVersion is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher as SystemWatcherLinux

        when:
        def systemVersion = systemProcessesWatcher.getSystemVersion()
        print systemVersion

        then:
        systemVersion != ""
    }

    def "getSystemId is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher as SystemWatcherLinux

        when:
        def systemId = systemProcessesWatcher.getSystemId()
        print systemId

        then:
        systemId != ""
    }
}

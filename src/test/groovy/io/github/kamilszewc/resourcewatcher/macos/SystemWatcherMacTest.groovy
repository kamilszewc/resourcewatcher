package io.github.kamilszewc.resourcewatcher.macos


import io.github.kamilszewc.resourcewatcher.watchers.macos.SystemWatcherMac
import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
import spock.lang.Specification

class SystemWatcherMacTest extends Specification {

    def "gives non null number of processes report"() {
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
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher as SystemWatcherMac

        when:
        def kernelReleaseVersion = systemProcessesWatcher.getKernelReleaseVersion()
        print kernelReleaseVersion

        then:
        kernelReleaseVersion != ""
    }

    def "getKernelVersion is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher as SystemWatcherMac

        when:
        def kernelVersion = systemProcessesWatcher.getKernelVersion()
        print kernelVersion

        then:
        kernelVersion != ""
    }

    def "getNodeName is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher as SystemWatcherMac

        when:
        def nodeName = systemProcessesWatcher.getNodeName()
        print nodeName

        then:
        nodeName != ""
    }

    def "getSystemIdentificationData is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher as SystemWatcherMac

        when:
        def systemIdentificationData = systemProcessesWatcher.getSystemIdentificationData()
        print systemIdentificationData

        then:
        systemIdentificationData != ""
    }

    def "getSystemName is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher as SystemWatcherMac

        when:
        def systemName = systemProcessesWatcher.getSystemName()
        print systemName

        then:
        systemName != ""
    }

    def "getSystemVersion is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher as SystemWatcherMac

        when:
        def systemVersion = systemProcessesWatcher.getSystemVersion()
        print systemVersion

        then:
        systemVersion != ""
    }

    def "getSystemId is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher as SystemWatcherMac

        when:
        def systemId = systemProcessesWatcher.getSystemId()
        print systemId

        then:
        systemId != ""
    }
}

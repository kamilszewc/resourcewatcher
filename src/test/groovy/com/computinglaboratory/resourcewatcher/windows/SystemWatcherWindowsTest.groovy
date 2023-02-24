package com.computinglaboratory.resourcewatcher.windows

import com.computinglaboratory.resourcewatcher.ResourceWatcherFactory
import spock.lang.Specification

class SystemWatcherWindowsTest extends Specification {

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
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher

        when:
        def kernelReleaseVersion = systemProcessesWatcher.getKernelReleaseVersion()
        print kernelReleaseVersion

        then:
        kernelReleaseVersion != ""
    }

    def "getKernelVersion is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher

        when:
        def kernelVersion = systemProcessesWatcher.getKernelVersion()
        print kernelVersion

        then:
        kernelVersion != ""
    }

    def "getNodeName is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher

        when:
        def nodeName = systemProcessesWatcher.getNodeName()
        print nodeName

        then:
        nodeName != ""
    }


    def "getSystemName is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher

        when:
        def systemName = systemProcessesWatcher.getSystemName()
        print systemName

        then:
        systemName != ""
    }

    def "getSystemVersion is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher

        when:
        def systemVersion = systemProcessesWatcher.getSystemVersion()
        print systemVersion

        then:
        systemVersion != ""
    }

    def "getSystemId is not empty"() {
        given:
        def systemProcessesWatcher = ResourceWatcherFactory.create().systemWatcher

        when:
        def systemId = systemProcessesWatcher.getSystemId()
        print systemId

        then:
        systemId != ""
    }
}

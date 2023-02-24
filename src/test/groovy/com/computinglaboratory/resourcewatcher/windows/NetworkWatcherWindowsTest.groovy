package com.computinglaboratory.resourcewatcher.windows

import com.computinglaboratory.resourcewatcher.ResourceWatcherFactory
import com.computinglaboratory.resourcewatcher.watchers.interfaces.NetworkWatcher
import spock.lang.Specification

class NetworkWatcherWindowsTest extends Specification {

    def "returns list of network interfaces"() {
        given:
        NetworkWatcher networkWatcher = ResourceWatcherFactory.create().networkWatcher

        when:
        def interfaces = networkWatcher.getListOfInterfaces()

        then:
        println interfaces
        interfaces != null
    }

}

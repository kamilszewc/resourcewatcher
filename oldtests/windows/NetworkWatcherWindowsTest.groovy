package io.github.kamilszewc.resourcewatcher.windows


import io.github.kamilszewc.resourcewatcher.watchers.interfaces.NetworkWatcher
import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
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

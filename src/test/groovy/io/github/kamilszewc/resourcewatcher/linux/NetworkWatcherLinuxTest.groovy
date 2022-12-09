package io.github.kamilszewc.resourcewatcher.linux


import io.github.kamilszewc.resourcewatcher.watchers.interfaces.NetworkWatcher
import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
import spock.lang.Specification


class NetworkWatcherLinuxTest extends Specification {

    def "returns list of network interfaces"() {
        given:
        NetworkWatcher networkWatcher = ResourceWatcherFactory.create().networkWatcher

        when:
        def interfaces = networkWatcher.getListOfInterfaces()

        then:
        println interfaces
        interfaces != null
    }

    def "returns not null transmit values for lo interface"() {
        given:
        NetworkWatcher networkWatcher = ResourceWatcherFactory.create().networkWatcher

        when:
        def speed = networkWatcher.getInterfaceTransmitSpeed("lo")

        then:
        println speed.getMbs()
        speed.getKbs() != null
    }

    def "returns not null receive values for lo interface"() {
        given:
        NetworkWatcher networkWatcher = ResourceWatcherFactory.create().networkWatcher

        when:
        def speed = networkWatcher.getInterfaceReceiveSpeed("wlp5s0")

        then:
        println speed.getMbs()
        speed.getKbs() != null
    }
}

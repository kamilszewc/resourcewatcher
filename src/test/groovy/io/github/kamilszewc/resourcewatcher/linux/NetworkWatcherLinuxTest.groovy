package io.github.kamilszewc.resourcewatcher.linux


import io.github.kamilszewc.resourcewatcher.watchers.interfaces.NetworkWatcher
import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory
import spock.lang.Specification


class NetworkWatcherLinuxTest extends Specification {

    def "returns not null transmit values for lo interface"() {
        given:
        NetworkWatcher networkWatcher = ResourceWatcherFactory.create().networkWatcher

        when:
        def speed = networkWatcher.getInterfaceTransmitSpeed("wlp5s0")

        then:
        println speed.value.Mbs()
        speed.value.Kbs() != null
    }

    def "returns not null receive values for lo interface"() {
        given:
        NetworkWatcher networkWatcher = ResourceWatcherFactory.create().networkWatcher

        when:
        def speed = networkWatcher.getInterfaceReceiveSpeed("wlp5s0")

        then:
        println speed.value.Mbs()
        speed.value.Kbs() != null
    }
}

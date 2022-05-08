package com.computinglaboratory.resourcewatcher.linux

import com.computinglaboratory.resourcewatcher.ResourceWatcherBuilder
import com.computinglaboratory.resourcewatcher.watchers.interfaces.NetworkWatcher
import spock.lang.Specification


class NetworkWatcherLinuxTest extends Specification {

    def "returns not null transmit values for lo interface"() {
        given:
        NetworkWatcher networkWatcher = ResourceWatcherBuilder.build().networkWatcher

        when:
        def speed = networkWatcher.getInterfaceTransmitSpeed("wlp5s0")

        then:
        println speed.value.Mbs()
        speed.value.Kbs() != null
    }

    def "returns not null receive values for lo interface"() {
        given:
        NetworkWatcher networkWatcher = ResourceWatcherBuilder.build().networkWatcher

        when:
        def speed = networkWatcher.getInterfaceReceiveSpeed("wlp5s0")

        then:
        println speed.value.Mbs()
        speed.value.Kbs() != null
    }
}

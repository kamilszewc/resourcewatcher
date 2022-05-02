package com.computinglaboratory.linuxresourcewatcher.linux


import com.computinglaboratory.linuxresourcewatcher.watchers.NetworkWatcher
import com.computinglaboratory.linuxresourcewatcher.watchers.linux.NetworkWatcherLinux
import spock.lang.Specification


class NetworkWatcherLinuxTest extends Specification {

    def "returns not null transmit values for lo interface"() {
        given:
        NetworkWatcher networkWatcher = new NetworkWatcherLinux()

        when:
        def speed = networkWatcher.getInterfaceTransmitSpeed("wlp5s0")

        then:
        println speed.value.Mbs()
        speed.value.Kbs() != null
    }

    def "returns not null receive values for lo interface"() {
        given:
        NetworkWatcher networkWatcher = new NetworkWatcherLinux()

        when:
        def speed = networkWatcher.getInterfaceReceiveSpeed("wlp5s0")

        then:
        println speed.value.Mbs()
        speed.value.Kbs() != null
    }
}

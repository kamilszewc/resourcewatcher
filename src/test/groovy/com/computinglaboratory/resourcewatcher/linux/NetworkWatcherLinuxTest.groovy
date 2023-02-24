package com.computinglaboratory.resourcewatcher.linux


import com.computinglaboratory.resourcewatcher.watchers.interfaces.NetworkWatcher
import com.computinglaboratory.resourcewatcher.ResourceWatcherFactory
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

    def "returns non null transmit data for lo interface"() {
        given:
        NetworkWatcher networkWatcher = ResourceWatcherFactory.create().networkWatcher

        when:
        def data = networkWatcher.getInterfaceTransmittedData("lo")

        then:
        println data.getB()
        data.getB() != null
    }

    def "returns not null receive data for lo interface"() {
        given:
        NetworkWatcher networkWatcher = ResourceWatcherFactory.create().networkWatcher

        when:
        def data = networkWatcher.getInterfaceReceivedData("lo")

        then:
        println data.getB()
        data.getB() != null
    }
}

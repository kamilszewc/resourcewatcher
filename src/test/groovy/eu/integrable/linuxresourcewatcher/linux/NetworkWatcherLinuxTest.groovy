package eu.integrable.linuxresourcewatcher.linux

import eu.integrable.linuxresourcewatcher.core.Report
import eu.integrable.linuxresourcewatcher.watchers.NetworkWatcher
import eu.integrable.linuxresourcewatcher.watchers.linux.NetworkWatcherLinux
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

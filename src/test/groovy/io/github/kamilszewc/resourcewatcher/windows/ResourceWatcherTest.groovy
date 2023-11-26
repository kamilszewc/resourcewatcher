package io.github.kamilszewc.resourcewatcher.windows

import io.github.kamilszewc.resourcewatcher.watchers.interfaces.ResourceWatcher
import spock.lang.Specification

class ResourceWatcherTest extends Specification {

    def "getOperatingSystem returns OperatingSystem"() {
        given:
        def operatingSystem = ResourceWatcher.getOperatingSystem()

        expect:
        operatingSystem == ResourceWatcher.OperatingSystem.WINDOWS
    }
}

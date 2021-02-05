import spock.lang.*

class SystemRamWatcherTest extends Specification {

    def "gives non zero total memory"() {
        given:
        def systemRamWatcher = new SystemRamWatcher()

        when:
        def totalMemory = systemRamWatcher.getTotalMemory()

        then:
        totalMemory != null && totalMemory != 0
    }

    def "gives non zero free memory"() {
        given:
        def systemRamWatcher = new SystemRamWatcher()

        when:
        def freeMemory = systemRamWatcher.getFreeMemory()

        then:
        freeMemory != null && freeMemory != 0
    }

    def "gives non zero available memory"() {
        given:
        def systemRamWatcher = new SystemRamWatcher()

        when:
        def availableMemory = systemRamWatcher.getAvailableMemory()

        then:
        availableMemory != null && availableMemory != 0
    }

    def "gives non zero cached"() {
        given:
        def systemRamWatcher = new SystemRamWatcher()

        when:
        def buffers = systemRamWatcher.getCached()

        then:
        buffers != null && buffers != 0
    }

    def "gives non zero buffers"() {
        given:
        def systemRamWatcher = new SystemRamWatcher()

        when:
        def buffers = systemRamWatcher.getBuffers()

        then:
        buffers != null && buffers != 0
    }
}

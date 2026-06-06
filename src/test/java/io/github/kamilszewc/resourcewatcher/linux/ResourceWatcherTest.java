package io.github.kamilszewc.resourcewatcher.linux;

import io.github.kamilszewc.resourcewatcher.watchers.interfaces.ResourceWatcher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResourceWatcherTest {

    @Test
    public void getOperatingSystem_ReturnsOperatingSystem() {
        // expect
        assertEquals(ResourceWatcher.OperatingSystem.LINUX, ResourceWatcher.getOperatingSystem());
    }
}
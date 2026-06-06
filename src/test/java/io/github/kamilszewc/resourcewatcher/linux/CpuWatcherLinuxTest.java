package io.github.kamilszewc.resourcewatcher.linux;
import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory;
import io.github.kamilszewc.resourcewatcher.exceptions.UnknownOperatingSystemException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CpuWatcherLinuxTest {

    @Test
    void getCpuInfoReturnsCpuInfo() throws UnknownOperatingSystemException, IOException {
        var cpuWatcher = ResourceWatcherFactory.create().getCpuWatcher();
        var cpuInfo = cpuWatcher.getCpuInfo();
        System.out.println(cpuInfo);
        assertNotNull(cpuInfo);
    }

}

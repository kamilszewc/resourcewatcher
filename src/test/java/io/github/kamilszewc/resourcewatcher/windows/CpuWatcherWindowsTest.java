package io.github.kamilszewc.resourcewatcher.windows;

import io.github.kamilszewc.resourcewatcher.ResourceWatcherFactory;
import io.github.kamilszewc.resourcewatcher.exceptions.UnknownOperatingSystemException;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.CpuWatcher;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class CpuWatcherWindowsTest {

    @Test
    public void getCpuInfo_ReturnsCpuInfo() throws UnknownOperatingSystemException, IOException {
        // given
        CpuWatcher cpuWatcher = ResourceWatcherFactory.create().getCpuWatcher();

        // when
        var cpuInfo = cpuWatcher.getCpuInfo();
        System.out.println(cpuInfo);

        // then
        assertNotNull(cpuInfo);
        assertNotEquals("Apple M1", cpuInfo.getName());
        assertEquals("12th Gen Intel(R) Core(TM) i7-1255U", cpuInfo.getName());
    }
}
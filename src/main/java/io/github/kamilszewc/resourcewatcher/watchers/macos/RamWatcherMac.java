package io.github.kamilszewc.resourcewatcher.watchers.macos;

import io.github.kamilszewc.resourcewatcher.core.Memory;
import io.github.kamilszewc.resourcewatcher.core.CommandCaller;
import io.github.kamilszewc.resourcewatcher.watchers.interfaces.RamWatcher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;

/**
 * RamWatcher class - MacOS specialization
 */
public class RamWatcherMac implements RamWatcher {

    private int getPageSize() {
        return 16384;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    static class PageStatistics {
        private Long free;
        private Long active;
        private Long inactive;
    }

    private PageStatistics getPageStatistics() throws IOException {

        String result = CommandCaller.call("vm_stat");
        String[] split = result.split("\n");

        PageStatistics pageStatistics = new PageStatistics();

        for (int i=1; i<split.length; i++) {
            var line = split[i].split(" ");
            if (line[1].equals("free:")) {
                pageStatistics.setFree(Float.valueOf(line[line.length-1]).longValue());
            }
            if (line[1].equals("active:")) {
                pageStatistics.setActive(Float.valueOf(line[line.length-1]).longValue());
            }
            if (line[1].equals("inactive:")) {
                pageStatistics.setInactive(Float.valueOf(line[line.length-1]).longValue());
            }
        }

        return pageStatistics;
    }

    @Override
    public Memory getTotalMemory() throws IOException {

        String result = CommandCaller.call("sysctl hw.memsize");
        String[] split = result.split(": ");
        Long value = Long.valueOf(split[1].trim());
        return new Memory(value);
    }

    @Override
    public Memory getFreeMemory() throws IOException {

        var vmStat = getPageStatistics();
        Long value = vmStat.getFree() * getPageSize();
        return new Memory(value);
    }

    @Override
    public Memory getAvailableMemory() throws IOException {

        var vmStat = getPageStatistics();
        Long value = (vmStat.getFree() + vmStat.getInactive()) * getPageSize();
        return new Memory(value);
    }

}

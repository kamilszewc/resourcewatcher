package com.computinglaboratory.resourcewatcher.watchers.universal;

import com.computinglaboratory.resourcewatcher.core.Memory;
import com.computinglaboratory.resourcewatcher.watchers.interfaces.DiskWatcher;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;

import java.io.File;
import java.io.IOError;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DiskWatcherUniversal implements DiskWatcher {

    @Override
    public Memory getFreePartitionSpace(String partition) throws IOError {

        File p = new File(partition);
        return new Memory((Long) DefaultGroovyMethods.intdiv(p.getFreeSpace(), 1024));
    }

    @Override
    public Memory getTotalPartitionSpace(String partition) throws IOError {

        File p = new File(partition);
        return new Memory((Long) DefaultGroovyMethods.intdiv(p.getTotalSpace(), 1024));
    }

    @Override
    public Memory getUsablePartitionSpace(String partition) throws IOError {

        File p = new File(partition);
        return new Memory((Long) DefaultGroovyMethods.intdiv(p.getUsableSpace(), 1024));
    }

    @Override
    public List<String> getListOfPartitions() throws IOError {

        return Arrays.stream(File.listRoots()).map(File::toString).collect(Collectors.toList());
    }

}

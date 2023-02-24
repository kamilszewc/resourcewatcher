package com.computinglaboratory.resourcewatcher.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Class that represents the information about CPU and the topology
 */
@Builder
@Getter
@AllArgsConstructor
@ToString
public class CpuInfo {
    private String name;
    private String vendor;
    private Integer numberOfCores;
    private Integer numberOfThreads;
    private Integer numberOfCoresPerSocket;
    private Integer numberOfThreadsPerSocket;
    private Integer numberOfSockets;
    private Integer numberOfThreadsPerCore;
    private Float frequency;

    /**
     * Constructor
     */
    public CpuInfo() {}

}

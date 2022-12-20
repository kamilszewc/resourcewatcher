package io.github.kamilszewc.resourcewatcher.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

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

}

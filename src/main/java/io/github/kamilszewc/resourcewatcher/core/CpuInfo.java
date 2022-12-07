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
    private int numberOfCores;
    private int numberOfThreads;
    private int numberOfCoresPerSocket;
    private int numberOfThreadsPerSocket;
    private int numberOfSockets;
    private int frequency;

}

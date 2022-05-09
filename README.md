# Resource Watcher

## General

Simple to use JVM library for watching linux/windows/mac resources like cpu-usage, memory, disk space, etc.

The library is written in Groovy and tested with Spock framework.

It was tested with:
- Ubuntu 18.04, 20.04, 22.04

## Installation

The compiled libraries are deployed to Maven Central.

Usage with maven:

```xml
<dependency>
    <groupId>com.computinglaboratory</groupId>
    <artifactId>resourcewatcher</artifactId>
    <version>2.1</version>
</dependency>
```

Usage with gradle:

```groovy
implementation 'com.computinglaboratory:resourcewatcher:2.1'
```

## Usage

Example in Java:

```java
    ResourceWatcher resourceWatcher = ResourceWatcherFactory.create();
    DiskWatcher diskWatcher = resourceWatcher.getDiskWatcher();
    Report<Memory> report = diskWatcher.getAvailablePartitionSpace("/");
    Long sizeInMB = partitionSize.getValue().MB();
```

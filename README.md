# Resource Watcher

## General

Simple to use JVM library for watching linux/windows/mac resources like cpu-usage, memory, disk space, etc.

The library is written in Java and tested with Spock framework.

It was tested with:
- Ubuntu 18.04, 20.04, 22.04
- MacOS 12

Windows platform is still not developed

## Installation

The compiled libraries are deployed to Maven Central.

Usage with maven:

```xml
<dependency>
    <groupId>com.computinglaboratory</groupId>
    <artifactId>resourcewatcher</artifactId>
    <version>3.0</version>
</dependency>
```

Usage with gradle:

```groovy
implementation 'com.computinglaboratory:resourcewatcher:3.0'
```

## Usage

Example in Java:

```java
    ResourceWatcher resourceWatcher = ResourceWatcherFactory.create();
    DiskWatcher diskWatcher = resourceWatcher.getDiskWatcher();
    Memory memory = diskWatcher.getFreePartitionSpace("/");
    Long sizeInMB = memory.MB();
```

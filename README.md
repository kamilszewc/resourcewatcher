# Resource Watcher

## General

Simple to use JVM library for watching linux/windows/mac resources like cpu-usage, memory, disk space, etc.

The library is written in Java and tested with Spock framework.

It was tested with:
- Ubuntu 18.04, 20.04, 22.04, 22.10, 23.04, 23.10, 24.04
- Debian 12
- OpenSUSE 15
- Fedora 37
- MacOS 12, 13, 14
- Windows 10, 11

## Installation

The compiled libraries are deployed to Maven Central.

Usage with maven:

```xml
<dependency>
    <groupId>io.github.kamilszewc</groupId>
    <artifactId>resourcewatcher</artifactId>
    <version>5.14</version>
</dependency>
```

Usage with gradle:

```groovy
implementation 'io.github.kamilszewc:resourcewatcher:5.14'
```

## Usage

Example in Java:

```java
    ResourceWatcher resourceWatcher = ResourceWatcherFactory.create();
    DiskWatcher diskWatcher = resourceWatcher.getDiskWatcher();
    Memory memory = diskWatcher.getFreePartitionSpace("/");
    Long sizeInMB = memory.MB();
```

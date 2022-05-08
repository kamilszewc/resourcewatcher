# Resource Watcher

Simple to use JVM library for watching linux/windows/mac resources like cpu-usage, memory, disk space, etc.

The library is written in Groovy and tested with Spock framework.

It was tested with:
- Ubuntu 18.04, 20.04, 22.04

## Usage

Example in Java:

```java
    ResourceWatcher resourceWatcher = ResourceWatcherBuilder.build();
    DiskWatcher diskWatcher = resourceWatcher.getDiskWatcher();
    Report<Memory> report = diskWatcher.getAvailablePartitionSpace("/");
    Long sizeInMB = partitionSize.getValue().MB();
```

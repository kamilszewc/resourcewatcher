package io.github.kamilszewc.resourcewatcher.core;

public class Memory {
    public long KB() {
        return value;
    }

    public long MB() {
        return KB() / 1024;
    }

    public long GB() {
        return MB() / 1024;
    }

    public long TB() {
        return GB() / 1024;
    }

    public long PB() {
        return TB() / 1024;
    }

    public Memory(Long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    private long value;
}

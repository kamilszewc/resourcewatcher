package io.github.kamilszewc.resourcewatcher.core;

public class Memory {

    public long getB() { return value; }

    public long getKB() {
        return getB() / 1024;
    }

    public long getMB() {
        return getKB() / 1024;
    }

    public long getGB() {
        return getMB() / 1024;
    }

    public long getTB() {
        return getGB() / 1024;
    }

    public long getPB() {
        return getTB() / 1024;
    }

    public Memory(Long value) {
        this.value = value;
    }

    public void setB(long value) {
        this.value = value;
    }

    private long value;
}

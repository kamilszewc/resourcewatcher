package io.github.kamilszewc.resourcewatcher.core;

/**
 * Class representing the memory
 */
public class Memory {

    /**
     * Returns a memory in bytes
     * @return memory in bytes
     */
    public long getB() { return value; }

    /**
     * Returns a memory in kilobytes
     * @return memory in kilobytes
     */
    public long getKB() {
        return getB() / 1024;
    }

    /**
     * Returns a memory in megabytes
     * @return memory in megabytes
     */
    public long getMB() {
        return getKB() / 1024;
    }

    /**
     * Returns a memory in gigabytes
     * @return memory in gigabytes
     */
    public long getGB() {
        return getMB() / 1024;
    }

    /**
     * Returns a memory in terabytes
     * @return memory in terabytes
     */
    public long getTB() {
        return getGB() / 1024;
    }

    /**
     * Returns a memory in petabytes
     * @return memory in petabytes
     */
    public long getPB() {
        return getTB() / 1024;
    }

    /**
     * Constructor
     * @param value bytes
     */
    public Memory(Long value) {
        this.value = value;
    }

    /**
     * Set bytes
     * @param value bytes
     */
    public void setB(long value) {
        this.value = value;
    }

    private long value;
}

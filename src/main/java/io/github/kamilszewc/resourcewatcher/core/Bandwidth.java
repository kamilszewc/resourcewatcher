package io.github.kamilszewc.resourcewatcher.core;

/**
 * Class representing the bandwidth.
 */
public class Bandwidth {

    /**
     * Returns a transfer in bytes per second
     * @return transfer in bytes per second
     */
    public double getBs() {
        return value;
    }

    /**
     * Returns a transfer in kilobytes per second
     * @return transfer in kilobytes per second
     */
    public double getKbs() {
        return value / 1024;
    }

    /**
     * Returns a transfer in megabytes per second
     * @return transfer in megabytes per second
     */
    public double getMbs() {
        return getKbs() / 1024;
    }

    /**
     * Returns a transfer in gigabytes per second
     * @return transfer in gigabytes per second
     */
    public double getGbs() {
        return getMbs() / 1024;
    }

    /**
     * Returns a transfer in terabytes per second
     * @return transfer in terabytes per second
     */
    public double getTbs() {
        return getTbs() / 1024;
    }

    /**
     * Constructor
     * @param value bytes per second
     */
    public Bandwidth(double value) {
        this.value = value;
    }

    /**
     * Set bytes per second
     * @param value bytes per second
     */
    public void setBs(double value) {
        this.value = value;
    }

    private double value;
}

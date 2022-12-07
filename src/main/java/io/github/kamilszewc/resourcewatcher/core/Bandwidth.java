package io.github.kamilszewc.resourcewatcher.core;

public class Bandwidth {

    public double getBs() {
        return value;
    }

    public double getKbs() {
        return value / 1024;
    }

    public double getMbs() {
        return getKbs() / 1024;
    }

    public double getGbs() {
        return getMbs() / 1024;
    }

    public double getTbs() {
        return getTbs() / 1024;
    }

    public Bandwidth(double value) {
        this.value = value;
    }

    public void setBs(double value) {
        this.value = value;
    }

    private double value;
}

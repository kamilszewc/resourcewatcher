package com.computinglaboratory.resourcewatcher.core;

public class Bandwidth {
    public double Kbs() {
        return value / 1024;
    }

    public double Mbs() {
        return Kbs() / 1024;
    }

    public double Gbs() {
        return Mbs() / 1024;
    }

    public double Tbs() {
        return Tbs() / 1024;
    }

    public Bandwidth(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    private double value;
}

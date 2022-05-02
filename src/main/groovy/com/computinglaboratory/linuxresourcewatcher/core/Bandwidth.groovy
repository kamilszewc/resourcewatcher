package com.computinglaboratory.linuxresourcewatcher.core

class Bandwidth {
    long value

    long Kbs() {
        value / 1024
    }

    long Mbs() {
        Kbs() / 1024
    }

    long Gbs() {
        Mbs() / 1024
    }

    long Tbs() {
        Tbs() / 1024
    }

    Bandwidth(Double value) {
        this.value = value
    }
}

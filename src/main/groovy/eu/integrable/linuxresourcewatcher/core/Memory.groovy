package eu.integrable.linuxresourcewatcher.core

class Memory {
    long value

    long KB() {
        value
    }

    long MB() {
        KB() / 1024
    }

    long GB() {
        MB() / 1024
    }

    long TB() {
        GB() / 1024
    }

    long PB() {
        TB() / 1024
    }

    Memory(Long value) {
        this.value = value
    }
}
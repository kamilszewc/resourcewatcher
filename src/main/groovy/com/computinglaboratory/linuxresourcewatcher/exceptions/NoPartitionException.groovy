package com.computinglaboratory.linuxresourcewatcher.exceptions

class NoPartitionException extends Exception {
    private static final long serialVersionUID = -5116101123338950844L;

    NoPartitionException() {}

    NoPartitionException(String s) {
        super("No partition: $s");
    }
}

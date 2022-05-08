package com.computinglaboratory.resourcewatcher.exceptions

class NoPartitionException extends Exception {

    NoPartitionException() {}

    NoPartitionException(String s) {
        super("No partition: $s");
    }
}

package io.github.kamilszewc.resourcewatcher.exceptions;

public class NoPartitionException extends Exception {
    public NoPartitionException() {
    }

    public NoPartitionException(String s) {
        super("No partition: " + s);
    }
}

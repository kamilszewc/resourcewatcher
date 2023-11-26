package io.github.kamilszewc.resourcewatcher.exceptions;

/**
 * Exception indicating that given disk partition does not exist
 */
public class NoPartitionException extends Exception {

    /**
     * NoPartitionException exception constructor
     */
    public NoPartitionException() {
    }

    /**
     * NoPartitionException exception constructor
     * @param message message
     */
    public NoPartitionException(String message) {
        super("No partition: " + message);
    }
}

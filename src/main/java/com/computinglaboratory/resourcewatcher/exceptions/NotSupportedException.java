package com.computinglaboratory.resourcewatcher.exceptions;

/**
 * Exception indicating that given functionality is not supported
 */
public class NotSupportedException extends RuntimeException {

    /**
     * NotSupportedException exception constructor
     */
    public NotSupportedException() {
    }

    /**
     * NotSupportedException exception constructor
     * @param message message
     */
    public NotSupportedException(String message) {
        super(message);
    }
}

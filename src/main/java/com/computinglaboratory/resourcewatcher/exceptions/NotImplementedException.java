package com.computinglaboratory.resourcewatcher.exceptions;

/**
 * Exception indicating that given functionality is not implemented yet
 */
public class NotImplementedException extends RuntimeException {

    /**
     * NotImplementedException exception constructor
     */
    public NotImplementedException() {
    }

    /**
     * NotImplementedException exception constructor
     * @param message message
     */
    public NotImplementedException(String message) {
        super(message);
    }
}

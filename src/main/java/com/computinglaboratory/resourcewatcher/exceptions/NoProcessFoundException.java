package com.computinglaboratory.resourcewatcher.exceptions;

/**
 * Exception indicating that given process can not by find
 */
public class NoProcessFoundException extends Exception {

    /**
     * NoProcessFoundException exception constructor
     */
    public NoProcessFoundException() {
    }

    /**
     * NoProcessFoundException exception constructor
     * @param message message
     */
    public NoProcessFoundException(String message) {
        super("No process found: " + message);
    }
}

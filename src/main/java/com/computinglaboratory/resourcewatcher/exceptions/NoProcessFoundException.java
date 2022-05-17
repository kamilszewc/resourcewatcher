package com.computinglaboratory.resourcewatcher.exceptions;

public class NoProcessFoundException extends Exception {
    public NoProcessFoundException() {
    }

    public NoProcessFoundException(String s) {
        super("No process found: " + s);
    }
}

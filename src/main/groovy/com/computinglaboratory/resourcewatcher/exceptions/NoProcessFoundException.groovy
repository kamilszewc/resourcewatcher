package com.computinglaboratory.resourcewatcher.exceptions

class NoProcessFoundException extends Exception {

    NoProcessFoundException() {}

    NoProcessFoundException(String s) {
        super("No process found: $s");
    }
}

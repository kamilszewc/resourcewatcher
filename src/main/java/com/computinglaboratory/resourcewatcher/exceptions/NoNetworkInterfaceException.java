package com.computinglaboratory.resourcewatcher.exceptions;

public class NoNetworkInterfaceException extends Exception {
    public NoNetworkInterfaceException() {
    }

    public NoNetworkInterfaceException(String s) {
        super("No network interface: " + s);
    }
}

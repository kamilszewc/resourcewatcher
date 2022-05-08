package com.computinglaboratory.resourcewatcher.exceptions

class NoNetworkInterfaceException extends Exception {

    NoNetworkInterfaceException() {}

    NoNetworkInterfaceException(String s) {
        super("No network interface: $s");
    }
}

package io.github.kamilszewc.resourcewatcher.exceptions;

/**
 * Exception indicating that given network interface does not exist
 */
public class NoNetworkInterfaceException extends Exception {

    /**
     * NoNetworkInterfaceException exception constructor
     */
    public NoNetworkInterfaceException() {
    }

    /**
     * NoNetworkInterfaceException exception constructor
     * @param message message
     */
    public NoNetworkInterfaceException(String message) {
        super("No network interface: " + message);
    }
}

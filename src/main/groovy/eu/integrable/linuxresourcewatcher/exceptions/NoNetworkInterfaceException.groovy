package eu.integrable.linuxresourcewatcher.exceptions

class NoNetworkInterfaceException extends Exception {
    private static final long serialVersionUID = -5116101123338950845L;

    NoNetworkInterfaceException() {}

    NoNetworkInterfaceException(String s) {
        super("No network interface: $s");
    }
}

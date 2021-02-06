package eu.integrable.linuxresourcewatcher.exceptions

class NoProcessFoundException extends Exception {
    private static final long serialVersionUID = -5116101123338950844L;

    NoProcessFoundException() {}

    NoProcessFoundException(String s) {
        super("No process found: $s");
    }
}

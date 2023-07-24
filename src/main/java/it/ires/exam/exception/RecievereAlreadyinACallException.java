package it.ires.exam.exception;

public class RecievereAlreadyinACallException extends Exception {
    public RecievereAlreadyinACallException() {
        super("The receiver is already in a call");
    }
}

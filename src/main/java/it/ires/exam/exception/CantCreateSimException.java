package it.ires.exam.exception;

public class CantCreateSimException extends Exception {
    public CantCreateSimException() {
        super("Can't create this SimCard");
    }
}

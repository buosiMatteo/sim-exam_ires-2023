package it.ires.exam.exception;

public class CantCreateSmartphoneException extends Exception {
    public CantCreateSmartphoneException() {
        super("Can't create this smartphone");
    }
}

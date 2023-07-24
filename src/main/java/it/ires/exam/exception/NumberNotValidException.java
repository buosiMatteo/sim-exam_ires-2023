package it.ires.exam.exception;

public class NumberNotValidException extends Exception {
    public NumberNotValidException(){
        super("This number is not valid");
    }
}

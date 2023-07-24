package it.ires.exam.exception;

public class NeverCallThisNumberException extends Exception {
    public NeverCallThisNumberException(){
        super("You never call this number yet");
    }
}

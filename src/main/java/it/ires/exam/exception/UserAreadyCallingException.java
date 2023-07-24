package it.ires.exam.exception;

public class UserAreadyCallingException extends Exception {
    public UserAreadyCallingException () {
        super("You're already in a call, sorry");
    }
}

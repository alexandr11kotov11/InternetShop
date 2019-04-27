package com.kotov.exception;


public class ExceptionForUser extends RuntimeException{

    public ExceptionForUser() {
    }

    public ExceptionForUser(String message) {
        super(message);
    }

    public ExceptionForUser(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionForUser(Throwable cause) {
        super(cause);
    }
}

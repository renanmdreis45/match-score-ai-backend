package com.matchscoreai.shared.exception;

public class InvalidCredentialsException
        extends RuntimeException {

    public InvalidCredentialsException() {
        super("Invalid credentials");
    }
}

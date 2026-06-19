package com.matchscoreai.shared.exception;

public class EmailAlreadyExistsException
        extends RuntimeException {

    public EmailAlreadyExistsException() {
        super("Email already exists");
    }
}

package com.imgarena.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {}

    public NotFoundException(final String message) {
        super(message);
    }
}

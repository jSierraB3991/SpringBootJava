package com.uber.displacement.infrastructure.Exception;

public class NotFoundException extends Exception {

    private static final long serialVersionUID = -8734270659205559927L;

    public NotFoundException(String message) {
        super(message);
    }
}

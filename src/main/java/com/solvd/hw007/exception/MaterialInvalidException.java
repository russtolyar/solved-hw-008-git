package com.solvd.hw007.exception;

public class MaterialInvalidException extends RuntimeException {

    public MaterialInvalidException(String message) {
        super(message);
    }

    public MaterialInvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}

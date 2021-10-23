package com.solvd.hw007.exception;

public class ElementHeightException extends RuntimeException{

    public ElementHeightException(String message) {
        super(message);
    }

    public ElementHeightException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.solvd.building_house.exception;

public class InvalidCountElementException extends RuntimeException {

    public InvalidCountElementException(String message) {
        super(message);
    }

    public InvalidCountElementException(String message, Throwable cause) {
        super(message, cause);
    }
}

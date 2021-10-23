package com.solvd.hw007.exception;

public class InvalidAddressException extends  Exception{

    public InvalidAddressException(String message) {
        super(message);
    }

    public InvalidAddressException(String message, Throwable cause) {
        super(message, cause);
    }
}


package com.solvd.buildinghouse.exception;


public class InvalidElementHeightException extends RuntimeException {

    public InvalidElementHeightException(String message) {
        super(message);
    }

    public InvalidElementHeightException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidElementHeightException() {

    }
}

package com.demo.exception;

public class MissingIngredientsException extends RuntimeException {

    public MissingIngredientsException(String message) {
        super(message);
    }
}

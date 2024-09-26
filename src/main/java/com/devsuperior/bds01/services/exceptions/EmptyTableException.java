package com.devsuperior.bds01.services.exceptions;

public class EmptyTableException extends RuntimeException{

    public EmptyTableException() {
    }

    public EmptyTableException(String message) {
        super(message);
    }
}

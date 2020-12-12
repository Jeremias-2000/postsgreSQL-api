package com.stock.service.exception;

public class UniqueCpfException extends Exception {
    private static final long serialVersionUID = 1L;

    public UniqueCpfException(String message) {
        super(message);
    }
}

package com.stock.service.exceptionService;

public class UniqueCpfException extends Exception {
    private static final long serialVersionUID = 1L;

    public UniqueCpfException(String message) {
        super(message);
    }
}

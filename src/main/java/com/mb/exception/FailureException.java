package com.mb.exception;

import java.util.Set;

public class FailureException extends RuntimeException {

    public FailureException(String message) {
        super(message);
    }
}
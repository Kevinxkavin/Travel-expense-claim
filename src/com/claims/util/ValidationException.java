package com.claims.util;

public class ValidationException extends Exception {
    public String toString() {
        return "Validation Failed: Invalid input data";
    }
}

package com.claims.util;

public class InsufficientLimitException extends Exception {
    public String toString() {
        return "Insufficient reimbursement balance";
    }
}

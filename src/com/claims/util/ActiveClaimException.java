package com.claims.util;

public class ActiveClaimException extends Exception {
    public String toString() {
        return "Employee has active claims. Cannot delete.";
    }
}

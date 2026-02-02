package com.claims.app;

import java.util.Date;
import java.util.Scanner;
import com.claims.service.ClaimSer;   // ✅ CORRECT IMPORT

class ClaimsMain {

	private static ClaimSer service;

	public static void main(String[] args) {

	    service = new ClaimSer();
	    Scanner input = new Scanner(System.in);

	    System.out.println("Expense Claim Console");

	    try {
	        boolean submitted = service.submitClaim(
	            "EMP1003", "Travel", 20000.00, new Date()
	        );
	        System.out.println(submitted ? "SUBMITTED" : "FAILED");
	    } catch (Exception ex) {
	        System.out.println(ex);
	    }

	    try {
	        boolean submitted = service.submitClaim(
	            "EMP1002", "Accommodation", 12000.00, new Date()
	        );
	        System.out.println(submitted ? "SUBMITTED" : "FAILED");
	    } catch (Exception ex) {
	        System.out.println(ex);
	    }

	    input.close();
	}

}

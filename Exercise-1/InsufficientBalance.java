package com.model;

/**
 * @author kumareshkaruppusamy
 * Custom exception for Insufficient Balance of the account
 */

public class InsufficientBalance extends Exception {
	String message;
	
	public InsufficientBalance(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return message;
	}
}

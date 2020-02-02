package com.rev.apitest.exception;

public class CurrencyMismatchException extends Exception {

	/**
	 * @author Akanksha
	 *
	 *Custom exception for Currency Mismatch 
	 */
	private static final long serialVersionUID = 7819750574601915318L;

	public CurrencyMismatchException(String message) {
		super(message);
	}
}

package com.rev.apitest.exception;

public class InsufficientFundException extends Exception {
	
	/**
	 * @author Akanksha
	 *
	 *Custom exception for Insufficient Fund 
	 */
	private static final long serialVersionUID = 7526427701155573949L;

	public InsufficientFundException(String message){
		super(message);
	}

}

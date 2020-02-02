package com.rev.apitest.exception;

public class InvalidAccountException extends Exception {

	/**
	 * @author Akanksha
	 *
	 *Custom exception for Invalid Account 
	 */
	private static final long serialVersionUID = 565632341858510715L;

	public InvalidAccountException(String message){
		super(message);
	}
}

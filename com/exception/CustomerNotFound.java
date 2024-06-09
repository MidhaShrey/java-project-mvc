package com.exception;

public class CustomerNotFound extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFound(String message) {
		super(message);
	}
}

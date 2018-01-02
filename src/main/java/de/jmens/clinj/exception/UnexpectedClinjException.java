package de.jmens.clinj.exception;

public class UnexpectedClinjException extends RuntimeException {

	public UnexpectedClinjException() {
	}

	public UnexpectedClinjException(String message) {
		super(message);
	}

	public UnexpectedClinjException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnexpectedClinjException(Throwable cause) {
		super(cause);
	}

	public UnexpectedClinjException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

package com.aperture.exceptions;

import okhttp3.internal.http2.ErrorCode;

public class ElementNotPresentInList extends RuntimeException {

	private static final long serialVersionUID = -8460356990632230194L;

	private final ErrorCode code;

	public ElementNotPresentInList(ErrorCode code) {
		super();
		this.code = code;
	}

	public ElementNotPresentInList(String message, Throwable cause, ErrorCode code) {
		super(message, cause);
		this.code = code;
	}

	public ElementNotPresentInList(String message, ErrorCode code) {
		super(message);
		this.code = code;
	}

	public ElementNotPresentInList(Throwable cause, ErrorCode code) {
		super(cause);
		this.code = code;
	}
	
	public ErrorCode getCode() {
		return this.code;
	}
}



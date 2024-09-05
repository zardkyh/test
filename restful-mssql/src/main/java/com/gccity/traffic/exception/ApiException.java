package com.gccity.traffic.exception;

import com.gccity.traffic.constant.ApiError;

import lombok.Getter;

public class ApiException extends Exception {
	@Getter
	private ApiError error;

	public ApiException() {
		this(ApiError.ERROR, null);
	}

	public ApiException(ApiError error) {
		this(error, null);
	}

	public ApiException(ApiError error, String message) {
		super(message);
		this.error = error;
	}
}

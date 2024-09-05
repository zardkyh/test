package com.gccity.traffic.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.gccity.traffic.constant.ApiError;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ErrorResponse {
	private ApiError apiError;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String message;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object details;

	public ErrorResponse(ApiError apiError, String message, Object details) {
		this.apiError = apiError;
		this.message = message;
		this.details = details;
	}

	@JsonGetter
	private boolean getSuccess() {
		return apiError.isSuccess();
	}

	@JsonGetter
	private int getCode() {
		return apiError.getCode();
	}

	@JsonGetter
	private String getMsg() {
		return apiError.getMsg();
	}
}

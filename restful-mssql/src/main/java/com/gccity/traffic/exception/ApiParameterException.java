package com.gccity.traffic.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.gccity.traffic.constant.ApiError;

import lombok.Data;
import lombok.Getter;

public class ApiParameterException extends ApiException {
	@Getter
	private List<ErrorInfo> fields;

	@Getter
	private String objectName;

	@Getter
	private int errorcode;

	@Getter
	private String errormessage;

	public ApiParameterException(BindingResult result, int code, String message) {
		super(ApiError.INVALID_PARAMETER);
		this.objectName = result.getObjectName();
		this.fields = result
			.getAllErrors().stream()
			.map(error -> {
				FieldError field = (FieldError)error;
				return new ErrorInfo(field.getObjectName(), field.getCode(), field.getField(),
					field.getDefaultMessage());
			})
			.collect(Collectors.toList());
		this.errorcode = code;
		this.errormessage = message;
	}

	@Data
	public class ErrorInfo {
		private String objectName;

		private String code;

		private String field;

		private String message;

		private boolean isCustom;

		ErrorInfo(String objectName, String code, String field, String message) {
			this.code = code;
			this.field = field;
			this.message = message;
			this.objectName = objectName;
		}
	}
}

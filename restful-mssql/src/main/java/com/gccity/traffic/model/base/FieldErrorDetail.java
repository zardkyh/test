package com.gccity.traffic.model.base;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class FieldErrorDetail {
	private String objectName;
	private String field;
	private String code;
	private String message;
}

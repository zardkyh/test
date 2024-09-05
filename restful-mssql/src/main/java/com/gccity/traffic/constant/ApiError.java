package com.gccity.traffic.constant;

import lombok.Getter;

public enum ApiError {
	ERROR(false, -1, "오류"),
	INVALID_PARAMETER(false, -100, "누락 또는 잘못된 형식으로 입력했습니다.");

	@Getter
	private final int code;

	@Getter
	private boolean success;

	@Getter
	private final String msg;

	ApiError(boolean success, int code, String description) {
		this.success = success;
		this.code = code;
		this.msg = description;
	}
}

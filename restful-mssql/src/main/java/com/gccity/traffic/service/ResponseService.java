package com.gccity.traffic.service;

import java.util.List;

import com.gccity.traffic.model.base.CommonResult;
import com.gccity.traffic.model.base.FieldErrorDetail;
import com.gccity.traffic.model.base.ListResult;
import com.gccity.traffic.model.base.SingleResult;

public interface ResponseService {

	<T> SingleResult<T> getSingleResult(T data);
	<T> SingleResult<T> getFailSingleResult(T data, int code, String msg);
	<T> ListResult<T> getListResult(List<T> list);
	CommonResult getSuccessResult();
	CommonResult getSuccessResult(String msg);
	CommonResult getSuccess(int code, String msg);
	CommonResult getFailResult(int code, String msg);
	CommonResult getFailResult(int code, String msg, List<FieldErrorDetail> errors);
}

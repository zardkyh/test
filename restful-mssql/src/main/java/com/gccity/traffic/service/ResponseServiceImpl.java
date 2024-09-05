package com.gccity.traffic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gccity.traffic.model.base.CommonResult;
import com.gccity.traffic.model.base.FieldErrorDetail;
import com.gccity.traffic.model.base.ListResult;
import com.gccity.traffic.model.base.SingleResult;

@Service
public class ResponseServiceImpl implements ResponseService {

	public enum CommonResponse {
		SUCCESS(200, "Success");
		int code;
		String msg;
		CommonResponse(int code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		public int getCode() {
			return code;
		}

		public String getMsg() {
			return msg;
		}
	}

	public <T> SingleResult<T> getSingleResult(T data) {
		SingleResult<T> result = new SingleResult<>();
		result.setData(data);
		setSuccessResult(result);
		return result;
	}

	public <T> SingleResult<T> getFailSingleResult(T data, int code, String msg) {
		SingleResult<T> result = new SingleResult<>();
		result.setData(data);
		setFailResult(result, code, msg);
		return result;
	}

	public <T> ListResult<T> getListResult(List<T> list) {
		ListResult<T> result = new ListResult<>();
		result.setList(list);
		setSuccessResult(result);
		return result;
	}

	public CommonResult getSuccessResult() {
		CommonResult result = new CommonResult();
		setSuccessResult(result);
		return result;
	}

	public CommonResult getSuccessResult(String msg) {
		CommonResult result = new CommonResult();
		setSuccessResult(result);
		result.setMsg(msg);
		return result;
	}

	public CommonResult getFailResult(int code, String msg) {
		CommonResult result = new CommonResult();
		result.setSuccess(false);
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}

	public CommonResult getFailResult(int code, String msg, List<FieldErrorDetail> errors) {
		CommonResult result = new CommonResult();
		result.setSuccess(false);
		result.setCode(code);
		result.setMsg(msg);
		result.setErrors(errors);
		return result;
	}

	public CommonResult getSuccess(int code, String msg) {
		CommonResult result = new CommonResult();
		result.setSuccess(true);
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}

	private void setSuccessResult(CommonResult result) {
		result.setSuccess(true);
		result.setCode(CommonResponse.SUCCESS.getCode());
		result.setMsg(CommonResponse.SUCCESS.getMsg());
	}

	private void setFailResult(CommonResult result, int code, String msg) {
		result.setSuccess(false);
		result.setCode(code);
		result.setMsg(msg);
	}
}

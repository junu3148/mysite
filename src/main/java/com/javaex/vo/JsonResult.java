package com.javaex.vo;

public class JsonResult {

	private String result; // success or fail
	private Object data; // 성공 했을때만 result=success
	private String failMsg; // 실패 했을때만 result=fail

	public JsonResult() {
		super();
	}

	public JsonResult(String result, Object data, String failMsg) {
		super();
		this.result = result;
		this.data = data;
		this.failMsg = failMsg;
	}
	
	

	public String getResult() {
		return result;
	}

	

	public Object getData() {
		return data;
	}


	public String getFailMsg() {
		return failMsg;
	}



	// 성공했을때 메서드
	public void success(Object data) {
		this.result = "success";
		this.data = data;

	}

	// 실패했을때 메서드
	public void fail(String msg) {
		this.result = "fail";
		this.failMsg = msg;
	}

	@Override
	public String toString() {
		return "JsonResult [result=" + result + ", data=" + data + ", failMsg=" + failMsg + "]";
	}

}

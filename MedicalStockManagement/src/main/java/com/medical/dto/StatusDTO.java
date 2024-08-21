package com.medical.dto;

public class StatusDTO implements DTO{
	
	private String code;
	private String result;
	private String message;

	public StatusDTO() {
		super();
	}
	
	public StatusDTO(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public StatusDTO(String code, String result, String message) {
		super();
		this.code = code;
		this.result = result;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "StatusDTO [code=" + code + ", result=" + result + ", message=" + message + "]";
	}
	
}

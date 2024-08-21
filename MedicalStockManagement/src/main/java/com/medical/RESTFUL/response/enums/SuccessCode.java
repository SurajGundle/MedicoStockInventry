package com.medical.RESTFUL.response.enums;

public enum SuccessCode {
	
	OK("200"),
	NO_CONTENT("204"),
	CREATED("201");
	
	private String code;
	
	private SuccessCode(String code) {
		this.code=code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String code) {
		this.code=code;
	}

}

package com.medical.RESTFUL.response.enums;

public enum StatusEnum {
	
	SUCCESS("Success"),
	FAILURE("Failure");
	
	private String value;
	
	private StatusEnum(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value=value;
	}

}

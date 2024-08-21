package com.medical.RESTFUL.resources.response.handler;

import com.medical.dto.DTO;

public class ResponseImpl implements Response {
	
	private DTO data;
	private DTO meta;
	private DTO status;


	@Override
	public DTO getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void setData(DTO data) {
		this.data=data;
		
	}

	@Override
	public void setStatus(DTO status) {
		this.status=status;
	}

	@Override
	public DTO getStatus() {
		return this.status;
	}

	@Override
	public DTO getMeta() {
		return meta;
	}

	@Override
	public void setMeta(DTO meta) {
		this.meta=meta;
	}

}

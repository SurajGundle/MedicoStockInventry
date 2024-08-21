package com.medical.RESTFUL.resources.response.handler;

import com.medical.dto.DTO;

public interface Response {
	
	public DTO getData();
	
	public void setData(DTO data);
	
	public void setStatus(DTO status);
	
	public DTO getStatus();
	
	public DTO getMeta();
	
	public void setMeta(DTO meta);
	

}

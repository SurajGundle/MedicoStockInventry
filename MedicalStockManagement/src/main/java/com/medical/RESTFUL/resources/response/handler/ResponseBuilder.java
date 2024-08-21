package com.medical.RESTFUL.resources.response.handler;

import java.util.ArrayList;
import java.util.List;

import com.medical.dto.DataDTO;
import com.medical.dto.MetaDTO;
import com.medical.dto.StatusDTO;

public class ResponseBuilder {
	
	private List<Object> results=new ArrayList<Object>();
	private StatusDTO status=new StatusDTO();
	
	private ResponseBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	public static ResponseBuilder builder() {
		ResponseBuilder builder=new ResponseBuilder();
		return builder;
	}
	
	public  ResponseBuilder results(List results) {
		if(results!=null) {
			this.results.addAll(results);
		}
		return this;
	}
	
	public  ResponseBuilder result(List results) {
		if(results!=null) {
			this.results.add(results);
		}
		return this;
	}

	public ResponseBuilder status(String result, String code,String message) {
		
		this.status.setResult(result);
		this.status.setCode(code);
		this.status.setMessage(message);
		return this;
	}
	
	public ResponseBuilder status(StatusDTO status) {
		this.status=status;
		return this;
	}
	
	public Response build() {
		DataDTO dataDTO=new DataDTO();
		dataDTO.setResults(results);
		
		MetaDTO metaDTO=new MetaDTO();
		metaDTO.setTimestamp(0);
		
		Response response=new ResponseImpl();
		response.setData(dataDTO);
		response.setMeta(metaDTO);
		response.setStatus(status);
		
		return response;
		
		
	}
	
	
	

	
}

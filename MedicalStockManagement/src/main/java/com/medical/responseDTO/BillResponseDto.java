package com.medical.responseDTO;

import java.util.Date;

import com.medical.entity.Product;

import lombok.Data;
@Data
public class BillResponseDto {
	private Integer billId;
	   private String patientName;
	   private Product name;
	   private Date billDate;
	   private double totalAmount;

}

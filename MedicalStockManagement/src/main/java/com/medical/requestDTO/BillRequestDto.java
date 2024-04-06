package com.medical.requestDTO;

import java.util.Date;

import com.medical.entity.Product;

import lombok.Data;

@Data
public class BillRequestDto {
   private Integer billId;
   private String patientName;
   private Product name;
   private Date billDate;
   private double totalAmount;
}

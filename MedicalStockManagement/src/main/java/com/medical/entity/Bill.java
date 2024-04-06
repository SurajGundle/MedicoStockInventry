package com.medical.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bill {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer billId;
	
	    private String patientName;
	//    private Product name;
	    private Date billDate;
	    private double totalAmount;

}

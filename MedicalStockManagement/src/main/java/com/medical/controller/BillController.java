package com.medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.entity.Bill;
import com.medical.exception.BillException;
import com.medical.requestDTO.BillRequestDto;
import com.medical.responseDTO.BillResponseDto;
import com.medical.service.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {
     @Autowired
     BillService billService;
     
     @PostMapping("/saveBill")
     public ResponseEntity<BillResponseDto>addBill(@RequestBody BillRequestDto billRequestDto){
		return new ResponseEntity<>(billService.saveBill(billRequestDto),HttpStatus.ACCEPTED);
    	 
     }
     @GetMapping("/getAll")
     public ResponseEntity<BillResponseDto>getBill(@RequestBody BillRequestDto billRequestDto) throws BillException{
		return new ResponseEntity<>(billService.getAllBills(),HttpStatus.FOUND);
    	 
     }
     @GetMapping("/getBill/{billId}")
     public ResponseEntity<BillResponseDto>getBill(@PathVariable ("billId")Integer billId) throws BillException{
 		
			return new ResponseEntity<>(billService.getBillById(billId),HttpStatus.FOUND);
		} 
		
     	 
      
     @DeleteMapping("/deleteBill/{billId}")
     public ResponseEntity<String>deleteBill(@PathVariable ("billId")Integer billId) throws BillException{
 		return new ResponseEntity<>(billService.deleteBillById(billId),HttpStatus.FOUND);
     	 
      }
     
     @PutMapping("/updateBill/{billId}")
     public ResponseEntity<BillResponseDto>updateBill(@PathVariable ("billId")Integer billId ,@RequestBody BillRequestDto billRequestDto) throws BillException{
  		return new ResponseEntity<>(billService.updateById(billId, billRequestDto),HttpStatus.FOUND);
      	 
       }
     
}

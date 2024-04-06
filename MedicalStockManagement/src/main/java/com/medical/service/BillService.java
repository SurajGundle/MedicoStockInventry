package com.medical.service;



import com.medical.entity.Bill;
import com.medical.exception.BillException;
import com.medical.requestDTO.BillRequestDto;
import com.medical.responseDTO.BillResponseDto;

public interface BillService {
    BillResponseDto saveBill(BillRequestDto billRequestDto);
	BillResponseDto getBillById(Integer billId) throws  BillException;
	 BillResponseDto getAllBills() throws  BillException;
	 String  deleteBillById(Integer billId) throws  BillException;
	 BillResponseDto updateById(Integer billId,BillRequestDto billRequestDto) throws  BillException;
}

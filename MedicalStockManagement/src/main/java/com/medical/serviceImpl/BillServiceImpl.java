package com.medical.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.entity.Bill;
import com.medical.entity.Stock;
import com.medical.exception.BillException;
import com.medical.exception.ProductException;
import com.medical.exception.StockException;
import com.medical.repository.BillRespository;
import com.medical.requestDTO.BillRequestDto;
import com.medical.responseDTO.BillResponseDto;
import com.medical.responseDTO.StockResponseDTO;
import com.medical.service.BillService;
@Service

public class BillServiceImpl implements BillService {
	@Autowired
	BillRespository billRepository;
	@Autowired
    ModelMapper modelMapper;
	
	   

	
	public BillResponseDto getBillById(Integer billId) throws BillException  {
		// TODO Auto-generated method stub
		Optional<Bill>opt=billRepository.findById(billId);
		if(opt.isEmpty()) {
			throw new BillException("ID is not present "+billId);
			
		}
		
		return modelMapper.map(opt, BillResponseDto.class);
		}
	
	@Override
	public BillResponseDto getAllBills() {
		// TODO Auto-generated method stub
		List<Bill> getAll=billRepository.findAll();
		return modelMapper.map(getAll, BillResponseDto.class);
	}
	@Override
	public String deleteBillById(Integer billId) throws BillException {
		Optional<Bill> opt = billRepository.findById(billId);
		    if (opt.isEmpty()) {
		        throw new BillException("Bill with ID " + billId + " not available");
		    }
		    Bill bill = opt.get();
		    billRepository.deleteById(billId);
		   BillResponseDto dto = modelMapper.map(bill, BillResponseDto.class);
		    return "Bill deleted successfully";
		}




	
	@Override
	public BillResponseDto saveBill(BillRequestDto billRequestDto) {
		// TODO Auto-generated method stub 
     Bill bill= modelMapper.map(billRequestDto, Bill.class);
		
		Bill saved=billRepository.save(bill);
		return modelMapper.map(saved, BillResponseDto.class);
	}
	
	@Override
	public BillResponseDto updateById(Integer billId, BillRequestDto billRequestDto) throws BillException {
		// TODO Auto-generated method stub
		Optional<Bill>opt=billRepository.findById(billId);
		  if (opt.isEmpty()) {
		        throw new BillException("Stock with ID " + billId + " not found");
		    }

	 Bill	exitingBill =opt.get();
	  exitingBill.setBillId(billRequestDto.getBillId());
	//  exitingBill.setName(billRequestDto.getName());
	  exitingBill.setBillDate(billRequestDto.getBillDate());
	  exitingBill.setPatientName(billRequestDto.getPatientName());
	  exitingBill.setTotalAmount(billRequestDto.getTotalAmount());
	  return modelMapper.map(billRequestDto, BillResponseDto.class);
		
	}

}

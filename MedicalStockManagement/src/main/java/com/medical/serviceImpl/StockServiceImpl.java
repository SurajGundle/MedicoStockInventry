package com.medical.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.entity.Product;
import com.medical.entity.Stock;
import com.medical.exception.StockException;
import com.medical.repository.StockRepository;
import com.medical.requestDTO.StockRequestDTO;
import com.medical.responseDTO.StockResponseDTO;
import com.medical.service.StockService;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StockResponseDTO addStock(StockRequestDTO stockRequestDTO) throws StockException {
		Stock stock= modelMapper.map(stockRequestDTO, Stock.class);
		Stock saved=stockRepository.save(stock);
		return modelMapper.map(saved, StockResponseDTO.class);
	}

	@Override
	public StockResponseDTO getStockById(Integer stockId) throws StockException {
		if(stockId ==null || stockRepository.findById(stockId).isEmpty()) {
			throw new StockException("Stock id either null or not present");
		}
		Optional<Stock> opt= stockRepository.findById(stockId);
		return modelMapper.map(opt.get(), StockResponseDTO.class);
	}

	@Override
	public String deleteStockById(Integer stockId) throws StockException {
		if(stockId ==null || stockRepository.findById(stockId).isEmpty()) {
			throw new StockException("Stock id either null or not present to delete");
		}
		
		 stockRepository.deleteById(stockId);
		 
		 return "deleted stock with id :"+stockId+" successfully";
	}

	@Override
	public StockResponseDTO updateStockById(Integer stockId, StockRequestDTO stockRequestDTO) throws StockException {
		
		 Optional<Stock> opt = stockRepository.findById(stockId);
		    if (opt.isEmpty()) {
		        throw new StockException("Stock with ID " + stockId + " not found");
		    }

		    Stock existingStock = opt.get();
		    existingStock.setStockName(stockRequestDTO.getStockName());
		    existingStock.setQuantityAvailable(stockRequestDTO.getQuantityAvailable());
		    existingStock.setLastUpdated(stockRequestDTO.getLastUpdated());
		   
		    try {
		    	stockRepository.save(existingStock);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    return modelMapper.map(existingStock, StockResponseDTO.class);

	}

	@Override
	public List<StockResponseDTO> getAllStock() {
	 
		List<Stock> stockList= stockRepository.findAll();
		List<StockResponseDTO> list=new ArrayList<>();
		for (Stock stock : stockList) {
			list.add(modelMapper.map(stock, StockResponseDTO.class)); 
		}
		return list;
		
	}
	
	
	    public List<Product> getProductsByStockId(Integer stockId) throws StockException {
	        Optional<Stock> optionalStock = stockRepository.findById(stockId);
	        if (optionalStock.isPresent()) {
	            Stock stock = optionalStock.get();
	            return stock.getProducts();
	        } else {
	            throw new StockException("Stock not found with id: " + stockId);
	        }
	    }
	}

    
    

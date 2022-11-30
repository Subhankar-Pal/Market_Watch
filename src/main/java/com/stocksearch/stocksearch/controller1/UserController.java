package com.stocksearch.stocksearch.controller1;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stocksearch.stocksearch.entities.Stock;
import com.stocksearch.stocksearch.services.StockService;

//Annotation
@RestController 

public class UserController {

	// We need a object of parent interface of StockService(StockServiceImpl) to call stock list
	@Autowired
	private StockService stockservice;
	
	//get the stocks
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getAllStocks")
	public List<Stock> getStocks(){
		return this.stockservice.getStocks();
	}
	
	// To send particular stock by its name 
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getAllStocks/{symbol}")
	public Stock getStock(@PathVariable String symbol) {
		return this.stockservice.getStock(symbol);
	}
	

	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/stocks")
	public Stock addStock(@RequestBody Stock stock) {
		return this.stockservice.addStock(stock);
	}
	
//	@CrossOrigin(origins = "http://localhost:3000")
//	@PostMapping("/stocks")
//	public List<Stock> addStock(@RequestBody List<Stock> list) {
//		return (List<Stock>) this.stockservice.addStock(list);
//	}
	
}

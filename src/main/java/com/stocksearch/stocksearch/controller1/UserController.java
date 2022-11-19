package com.stocksearch.stocksearch.controller1;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@PostMapping("/getAllStocks")
	public List<Stock> getStocks(){
		return this.stockservice.getStocks();
	}
	
	// To send particular stock by its name 
	@PostMapping("/getAllStocks/{symbol}")
	public Stock getStock(@PathVariable String symbol) {
		return this.stockservice.getStock(symbol);
	}
	
	@PostMapping("/stocks")
	public Stock addStock(@RequestBody Stock stock) {
		return this.stockservice.addStock(stock);
	}
	
}

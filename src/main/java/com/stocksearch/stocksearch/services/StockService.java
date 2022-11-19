package com.stocksearch.stocksearch.services;

import java.util.List;

import com.stocksearch.stocksearch.entities.Stock;

public interface StockService {
	public List<Stock> getStocks();  
	
	// Run Time Polymorphism
	public Stock getStock(String symbol);
	public Stock addStock(Stock stock);
}

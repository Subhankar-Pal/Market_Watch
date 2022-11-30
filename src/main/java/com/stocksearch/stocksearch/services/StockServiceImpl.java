package com.stocksearch.stocksearch.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocksearch.stocksearch.dao.StockDao;
import com.stocksearch.stocksearch.entities.Stock;
import com.stocksearch.stocksearch.model.StockResponse;

@Service   // This is annotation to identify that this is our service class to provide implementation
public class StockServiceImpl implements StockService{
	
	@Autowired
	private StockDao stockDao;
	

	@Override
	public List<Stock> getStocks(){
		return stockDao.findAll();
	}
	
//	public StockResponse findBySymbolWithDetails() {
//		return stockDao.findBySymbolWithDetails();
//	}

	@Override
	public Stock getStock(String symbol) {
		
		return stockDao.findBySymbol(symbol);
	}
	@Override
	public Stock addStock(Stock stock) {
		stockDao.save(stock);
		return stock;
	}

//@Override
//public Stock addStock(List<Stock> list) {
//	// TODO Auto-generated method stub
//	stockDao.saveAll(list);
//	return (Stock) list;
//}
}

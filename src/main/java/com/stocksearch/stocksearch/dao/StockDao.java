package com.stocksearch.stocksearch.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stocksearch.stocksearch.entities.Admin;
import com.stocksearch.stocksearch.entities.Stock;
import com.stocksearch.stocksearch.model.StockResponse;

@Repository
public interface StockDao extends JpaRepository<Stock,Integer> {
	
	Stock findBySymbol(String symbol);
	@Query(value = "Select * from Stocks",nativeQuery = true)
	StockResponse findBySymbolWithDetails();
	
	
}

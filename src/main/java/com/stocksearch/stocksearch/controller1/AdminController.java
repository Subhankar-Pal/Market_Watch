package com.stocksearch.stocksearch.controller1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocksearch.stocksearch.entities.Stock;
import com.stocksearch.stocksearch.services.StockService;

@RestController
public class AdminController {
	
	private StockService stockservice;
	
	
}

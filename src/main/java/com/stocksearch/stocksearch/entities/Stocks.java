package com.stocksearch.stocksearch.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "stock")
public class Stocks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int stockId;
	private String symbol;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Stock ohlc;
	
	
	public Stocks(int stockId, String symbol, Stock ohlc) {
		super();
		this.stockId = stockId;
		this.symbol = symbol;
		this.ohlc = ohlc;
	}
	public Stocks() {
		super();
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Stock getOhlc() {
		return ohlc;
	}
	public void setOhlc(Stock ohlc) {
		this.ohlc = ohlc;
	}
	@Override
	public String toString() {
		return "Stocks [stockId=" + stockId + ", symbol=" + symbol + ", ohlc=" + ohlc + "]";
	}
	
}

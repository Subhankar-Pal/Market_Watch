package com.stocksearch.stocksearch.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table(name = "market_stock")
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	
//	private int stock_ohlc_id;
	private int stock_id;
	private String symbol;
	private double open;
	private double high;
	private double low;
	private double close;
	public Stock(int stock_id, String symbol, double open, double high, double low, double close) {
		super();
		this.stock_id = stock_id;
		this.symbol = symbol;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
	}
	@Override
	public String toString() {
		return "Stock [stock_id=" + stock_id + ", symbol=" + symbol + ", open=" + open + ", high=" + high + ", low="
				+ low + ", close=" + close + "]";
	}
	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public Stock() {
		super();
	}
	
//	
//	public Stock(int stock_ohlc_id, double open, double high, double low, double close) {
//		super();
//		this.stock_ohlc_id = stock_ohlc_id;
//		this.open = open;
//		this.high = high;
//		this.low = low;
//		this.close = close;
//	}
//	
//	public Stock() {
//		super();
//	}
//
//	public int getStock_ohlc_id() {
//		return stock_ohlc_id;
//	}
//	public void setStock_ohlc_id(int stock_ohlc_id) {
//		this.stock_ohlc_id = stock_ohlc_id;
//	}
//	public double getOpen() {
//		return open;
//	}
//	public void setOpen(double open) {
//		this.open = open;
//	}
//	public double getHigh() {
//		return high;
//	}
//	public void setHigh(double high) {
//		this.high = high;
//	}
//	public double getLow() {
//		return low;
//	}
//	public void setLow(double low) {
//		this.low = low;
//	}
//	public double getClose() {
//		return close;
//	}
//	public void setClose(double close) {
//		this.close = close;
//	}
//	@Override
//	public String toString() {
//		return "Stock [stock_ohlc_id=" + stock_ohlc_id + ", open=" + open + ", high=" + high + ", low=" + low
//				+ ", close=" + close + "]";
//	}

}

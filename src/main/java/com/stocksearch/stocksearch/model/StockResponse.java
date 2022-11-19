package com.stocksearch.stocksearch.model;

public class StockResponse {
	
	private Integer stock_id;
	private String  symbol;
	private Double open;
	private Double high;
	private Double low;
	private Double close;
	public StockResponse(Integer stock_id, String symbol, Double open, Double high, Double low, Double close) {
		super();
		this.stock_id = stock_id;
		this.symbol = symbol;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
	}
	
	public StockResponse() {
		super();
	}

	public Integer getStock_id() {
		return stock_id;
	}
	public void setStock_id(Integer stock_id) {
		this.stock_id = stock_id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Double getOpen() {
		return open;
	}
	public void setOpen(Double open) {
		this.open = open;
	}
	public Double getHigh() {
		return high;
	}
	public void setHigh(Double high) {
		this.high = high;
	}
	public Double getLow() {
		return low;
	}
	public void setLow(Double low) {
		this.low = low;
	}
	public Double getClose() {
		return close;
	}
	public void setClose(Double close) {
		this.close = close;
	}
	@Override
	public String toString() {
		return "StockResponse [stock_id=" + stock_id + ", symbol=" + symbol + ", open=" + open + ", high=" + high
				+ ", low=" + low + ", close=" + close + "]";
	}
	
	
}

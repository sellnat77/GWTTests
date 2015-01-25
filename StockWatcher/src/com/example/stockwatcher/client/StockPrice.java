package com.example.stockwatcher.client;

public class StockPrice 
{
	private String symbol;
	private double price;
	private double change;
	
	public StockPrice(){}
	
	public StockPrice(String symbol, double price, double change)
	{
		this.symbol = symbol;
		this.price = price;
		this.change = change;
	}
	
	public String getSymbol()
	{
		return symbol;
	}
	public double getPrice()
	{
		return price;
	}
	public double getChange()
	{
		return change;
	}
	
	public void setSymbol(String sym)
	{
		this.symbol = sym;
	}
	public void setPrice(double pri)
	{
		this.price = pri;
	}
	public void setChange(double chang)
	{
		this.change = chang;
	}
	
	public double getChangePercent()
	{
		return 10.0 * this.change / this.price;
	}

}

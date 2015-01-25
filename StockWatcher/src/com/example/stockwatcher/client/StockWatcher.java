package com.example.stockwatcher.client;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

public class StockWatcher implements EntryPoint 
{
	private static final int REFRESH_INTERVAL = 5000;
	private VerticalPanel   mainPanel        = new VerticalPanel();
	private FlexTable       stocksFlexTable  = new FlexTable();
	private HorizontalPanel addPanel         = new HorizontalPanel();
	private TextBox         newSymbolTextBox = new TextBox();
	private Button          addStockButton   = new Button("Add your symbol");
	private Label           lastUpdatedLabel = new Label();
	private ArrayList<String> stocks = new ArrayList<String>();

	public void onModuleLoad() 
	{
		stocksFlexTable.setText(0, 0, "Symbol");
		stocksFlexTable.setText(0, 1, "Price" );
		stocksFlexTable.setText(0, 2, "Change");
		stocksFlexTable.setText(0, 3, "Remove");
		
		stocksFlexTable.getRowFormatter().addStyleName(0,"watchListHeader");
		stocksFlexTable.addStyleName("watchList");
		stocksFlexTable.getCellFormatter().addStyleName(0, 1, "watchListNumericColumn");
		stocksFlexTable.getCellFormatter().addStyleName(0, 2, "watchListNumericColumn");
		stocksFlexTable.getCellFormatter().addStyleName(0, 3, "watchListRemoveColumn");
		
		addPanel.add(newSymbolTextBox);
		addPanel.add(addStockButton  );
		addPanel.addStyleName("addPanel");
		
		mainPanel.add(stocksFlexTable );
		mainPanel.add(addPanel        ); 
		mainPanel.add(lastUpdatedLabel);
		
		RootPanel.get("stockList").add(mainPanel);
		
		newSymbolTextBox.setFocus(true);
		
		Timer refreshTimer = new Timer()
		{
			@Override
			public void run()
			{
				refreshWatchList();
			}
		};
		refreshTimer.scheduleRepeating(REFRESH_INTERVAL);
		
		ClickHandler myClickHandler = new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				addStock();
			}
		};
		
		
		KeyDownHandler myKeyDownHandler = new KeyDownHandler()
		{
			public void onKeyDown(KeyDownEvent event)
			{
				if(event.getNativeKeyCode() == KeyCodes.KEY_ENTER)
				{
					addStock();
				}
			}
		};
		
		addStockButton.addClickHandler(myClickHandler);			
		newSymbolTextBox.addKeyDownHandler(myKeyDownHandler);		
		}	
	
	private void addStock()
	{
		final String symbol = newSymbolTextBox.getText().toUpperCase().trim();
		newSymbolTextBox.setFocus(true);
		
		if(!symbol.matches("^[0-9A-Z&#92;.]{1,10}$"))
		{
			Window.alert("'" + symbol + "' is not a valid symbol!");
			newSymbolTextBox.selectAll();
			return;
		}
		if(stocks.contains(symbol))
		{
			return;
		}
		int row = stocksFlexTable.getRowCount();
		stocks.add(symbol);
		stocksFlexTable.setText(row,0,symbol);
		stocksFlexTable.setWidget(row,2,new Label());
		newSymbolTextBox.setText("");
		
		ClickHandler removeStockHandler = new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				int removedIndex = stocks.indexOf(symbol);
				stocks.remove(removedIndex);
				stocksFlexTable.removeRow(removedIndex+1);
			}
		};
		
		Button removeStockButton = new Button("Remove");
		removeStockButton.addClickHandler(removeStockHandler);
		removeStockButton.addStyleDependentName("remove");
		
		stocksFlexTable.setWidget(row, 3, removeStockButton);
		stocksFlexTable.getCellFormatter().addStyleName(row, 1, "watchListNumericColumn");
		stocksFlexTable.getCellFormatter().addStyleName(row, 2, "watchListNumericColumn");
		stocksFlexTable.getCellFormatter().addStyleName(row, 3, "watchListNumericColumn");
	}
	
	@SuppressWarnings("deprecation")
	private void updateTable(StockPrice[] prices)
	{
		for (int k = 0; k < prices.length; k++)
		{
			updateTable(prices[k]);
		}
		
		lastUpdatedLabel.setText("Last Updated: " + DateTimeFormat.getMediumDateTimeFormat().format(new Date()));
	}
	
	private void updateTable(StockPrice price)
	{
		if(!stocks.contains(price.getSymbol()))
		{
			return;	
		}
		
		int row = stocks.indexOf(price.getSymbol()) + 1;
		
		String priceText = NumberFormat.getFormat("#,##0.00").format(price.getPrice());
		NumberFormat changeFormat = NumberFormat.getFormat("+#,##0.00;-#,##0.00");
		
		String changeText = changeFormat.format(price.getChange());
		String changePercentText = changeFormat.format(price.getChangePercent());
		
		stocksFlexTable.setText(row, 1, priceText);
		//stocksFlexTable.setText(row,2,changeText + " (" + changePercentText + "%)");
		Label changeWidget = (Label)stocksFlexTable.getWidget(row,2);
		changeWidget.setText(changeText + " (" + changePercentText + "%)");
		
		String changeStyleName = "noChange";
		if(price.getChangePercent() < -0.1f)
		{
			changeStyleName = "negativeChange";
		}
		else if(price.getChangePercent() > -0.1f)
		{
			changeStyleName = "positiveChange";
		}
		
		changeWidget.setStyleName(changeStyleName);
	}
	
	private void refreshWatchList()
	{
		final double MAX_PRICE = 100.0;
		final double MAX_PRICE_CHANGE = 0.02;
		
		StockPrice[] prices = new StockPrice[stocks.size()];
		
		for(int k = 0; k < stocks.size(); k++)
		{
			double price = Random.nextDouble() * MAX_PRICE;
			double change = price * MAX_PRICE_CHANGE * (Random.nextDouble() * 2.0 -1.0);
			
			prices[k] = new StockPrice(stocks.get(k),price,change);
			
		}	
		updateTable(prices);
	}
}

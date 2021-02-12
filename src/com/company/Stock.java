package com.company;

public class Stock extends Product {
    private String ticker;
    private String exchange;

    public Stock(String productId, String ticker, String exchange) {
        super(productId);
        this.ticker = ticker;
        this.exchange = exchange;
    }


}

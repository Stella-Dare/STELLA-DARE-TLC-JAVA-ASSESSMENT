package com.company;

public class Future extends Product {
    private String exchange;
    private String contractCode;
    private int month;
    private int year;

    public Future(String productId, String exchange, String contractCode, int month, int year) {
        super(productId);
        this.exchange = exchange;
        this.contractCode = contractCode;
        this.month = month;
        this.year = year;
    }


}

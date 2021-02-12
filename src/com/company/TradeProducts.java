package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TradeProducts implements MontrealTradedProducts {
    private List<Product> products = new ArrayList<>();

    @Override
    public void addNewProduct(Product product) throws ProductAlreadyRegisteredException {
        List<Product> filterProducts = products.stream().filter(prod -> prod.getProductId() == product.getProductId()).collect(Collectors.toList());
        if (filterProducts.isEmpty()) {
            this.products.add(product);
        } else {
            throw new ProductAlreadyRegisteredException("Product with ID: " + product.getProductId() + " already registered");
        }
    }

    @Override
    public void trade(Product product, int quantity) {
        List<Product> filterProducts = products.stream().filter(prod -> prod.getProductId() == product.getProductId()).collect(Collectors.toList());
        if (!filterProducts.isEmpty()) {
            filterProducts.get(0).setQuantity(product.getQuantity() + quantity);
        }

    }

    @Override
    public int totalTradeQuantityForDay() {
        return products.stream().map(prod -> prod.getQuantity()).reduce(0, (a, b) -> a + b);
    }

    @Override
    public double totalValueOfDaysTradedProducts() {
        return 0;
    }

    public int getTotalProducts() {
        return products.size();
    }

    public int getQuantityOfProduct(Product product) {
        List<Product> filterProducts = products.stream().filter(prod -> prod.getProductId() == product.getProductId()).collect(Collectors.toList());
        return filterProducts.get(0).getQuantity();
    }
}

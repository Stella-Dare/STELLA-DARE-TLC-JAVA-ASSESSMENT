package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;

class TradeProductsTest {

    @Test
    void testAddNewProduct() throws ProductAlreadyRegisteredException {
        Product mockProduct = mock(Stock.class);
        TradeProducts tradeProduct = new TradeProducts();
        tradeProduct.addNewProduct(mockProduct);
        assertEquals(1, tradeProduct.getTotalProducts(), "Could not add new product");
    }

    @Test
    void testIfExceptionThrownWhenAddingExistingProduct() throws ProductAlreadyRegisteredException {
        Product mockProduct = mock(Stock.class);
        TradeProducts tradeProduct = new TradeProducts();
        tradeProduct.addNewProduct(mockProduct);
        assertThrows(ProductAlreadyRegisteredException.class, () -> tradeProduct.addNewProduct(mockProduct), "Exception was not thrown when already registered product added");
    }

    @Test
    void testTradeNotBookedIfProductNotRegistered()  {
        Product mockProduct = mock(Future.class);
        TradeProducts tradeProduct = new TradeProducts();
        tradeProduct.trade(mockProduct, 5);
        assertEquals(0, mockProduct.getQuantity());

    }

    @Test
    void totalTradeQuantityForDay() {
    }

    @Test
    void totalValueOfDaysTradedProducts() {
    }
}
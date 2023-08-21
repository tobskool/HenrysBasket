package com.HenrysShop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class HenrysTest {
    @Test
    public void checkStockPopulation1() {
        //test case for integers
        ArrayList<StockItems> stock = Stock.populateStock();

        int expectedValue = 4;
        int actualValue = stock.size();
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkForBread2() {
        //test case for string

        ArrayList<StockItems> stock = new ArrayList<>();
        stock.add(new StockItems("bread", "loaf", 0.80));
        String expectedValue = "bread";
        String actualValue = stock.get(0).getName();
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkForBreadinStock3() {
        ArrayList<StockItems> stock = Stock.populateStock();

        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).getName().equals("bread")) {
                String expectedValue = "bread";
                String actualValue = stock.get(i).getName();
                Assertions.assertEquals(expectedValue, actualValue);
            }
        }

    }

    @Test
    public void checksoupPrice4() {
        StockItems soup = new StockItems("soup", "tin", 0.65);
        double expectedValue = 0.65;
        double actualValue = soup.getPrice();
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkItemsAddedtoBasket5() {
        ArrayList<StockItems> stock = Stock.populateStock();

        stock.get(0).increaseCount(2);//soup
        stock.get(1).increaseCount(1);//bread
        stock.get(3).increaseCount(1);//apple

        int expectedValue = 4;
        int expectedIndividualValue = 1;
        int actualValue = 0;

        for (int i = 0; i < stock.size(); i++) {
            actualValue += stock.get(i).getCount();
        }

        boolean result = (expectedValue == actualValue) && (expectedIndividualValue == stock.get(1).getCount());

        assert result;

    }

    @Test
    public void checkTotalPrice6() {
        ArrayList<StockItems> stock = Stock.populateStock();

        stock.get(0).increaseCount(2);
        stock.get(1).increaseCount(1);
        stock.get(3).increaseCount(1);

        String expectedValue = "2.70";
        String actualValue = DiscountPrice.totalPrice(stock, -1);

        Assertions.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void checkTotalPricewithDiscount7() {
        ArrayList<StockItems> stock = Stock.populateStock();

        stock.get(0).increaseCount(2);//soup
        stock.get(2).increaseCount(1);//bread

        String expectedValue = "1.70";
        String actualValue = DiscountPrice.totalPrice(stock, 0);


        Assertions.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void test1FortotalPrice8() {
        ArrayList<StockItems> stock = Stock.populateStock();

        stock.get(0).increaseCount(3);//apple
        stock.get(2).increaseCount(2);//bread

        String expectedValue = "3.15";
        String actualValue = DiscountPrice.totalPrice(stock, 0);

        Assertions.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void test2FortotalPrice9() {
        ArrayList<StockItems> stock = Stock.populateStock();

        stock.get(1).increaseCount(1);//milk
        stock.get(3).increaseCount(6);//apple

        String expectedValue = "1.90";
        String actualValue = DiscountPrice.totalPrice(stock, 0);

        Assertions.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void test3FortotalPrice10() {
        ArrayList<StockItems> stock = Stock.populateStock();

        stock.get(1).increaseCount(1);//milk
        stock.get(3).increaseCount(6);//apple

        String expectedValue = "1.84";
        String actualValue = DiscountPrice.totalPrice(stock, 5);

        Assertions.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void test4FortotalPrice11() {
        ArrayList<StockItems> stock = Stock.populateStock();

        stock.get(0).increaseCount(2);//soup
        stock.get(2).increaseCount(1);//bread
        stock.get(3).increaseCount(3);//apple

        String expectedValue = "1.97";
        String actualValue = DiscountPrice.totalPrice(stock, 5);

        Assertions.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void checkTotalPricewithDiscount12() {
        ArrayList<StockItems> stock = Stock.populateStock();

        stock.get(0).increaseCount(2);//soup
        stock.get(2).increaseCount(2);//bread

        String expectedValue = "2.50";
        String actualValue = DiscountPrice.totalPrice(stock, 5);

        Assertions.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void checkTotalPricewithDiscount13() {
        ArrayList<StockItems> stock = Stock.populateStock();

        stock.get(0).increaseCount(4);//soup
        stock.get(2).increaseCount(2);//bread

        String expectedValue = "3.40";
        String actualValue = DiscountPrice.totalPrice(stock, 0);

        Assertions.assertEquals(expectedValue, actualValue);

    }

    //total price with discount - days is included.
}

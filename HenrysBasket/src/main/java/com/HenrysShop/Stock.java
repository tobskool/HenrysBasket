package com.HenrysShop;

import java.util.ArrayList;

public class Stock {

    public static ArrayList<StockItems> populateStock() {
        ArrayList<StockItems> stock = new ArrayList<>();
        stock.add(new StockItems("soup", "tin", 0.65));
        stock.add(new StockItems("milk", "bottle", 1.30));
        stock.add(new StockItems("bread", "loaf", 0.80));
        stock.add(new StockItems("apple", "single", 0.10));

        return stock;
    }
}

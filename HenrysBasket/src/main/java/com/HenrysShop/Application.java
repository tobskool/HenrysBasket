package com.HenrysShop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    public static ArrayList<StockItems> stock = new ArrayList<>();
    //stock to be checked for discounts

    public static int NoDBP;

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        stock = Stock.populateStock();
        printItems(stock);

        boolean paid = false;
        boolean validItemAdded = false;
        String input;
        System.out.print("How many days after purchase: ");
        input = myObj.nextLine();
        NoDBP = Integer.parseInt(input);
        while (!paid) {
            System.out.print("Add Item to Basket and Number of Items: ");
            input = myObj.nextLine();
            String[] Input = input.split(" ");
            int numberOfItems = 0;
            if (Input.length == 2) {
                numberOfItems = Integer.parseInt(Input[1]);
            } else if (Input.length == 1 && !Input[0].equals("")) {
                numberOfItems = 1;
            }
            for (int i = 0; i < stock.size(); i++) {
                if (Input[0].toLowerCase().equals(stock.get(i).getName()) || Input[0].toLowerCase().compareTo(stock.get(i).getUnit()) == 0) {
                    stock.get(i).increaseCount(numberOfItems);
                    validItemAdded = true;
                    break;
                } else {
                    validItemAdded = false;
                }
            }
            if (!validItemAdded) {
                if (Input[0].equals("")){
                    System.out.println("Do you want to pay? (Y/N)");
                }
                else{
                    System.out.println("Invalid Item: Do you want to pay? (Y/N)");
                }
                input = myObj.nextLine();
                if (input.toUpperCase().compareTo("Y") == 0) {

                    System.out.println("Total Price: " + DiscountPrice.totalPrice(stock, NoDBP));
                    paid = true;
                }
            }
        }

    }
    public static void printItems(ArrayList<StockItems> stock){
        System.out.println("In Stock Items:");
        for (int i = 0; i < stock.size(); i++){
            System.out.println("\t" + "Item: " + stock.get(i).getName() + "\t Unit: " + stock.get(i).getUnit());
        }
    }

}

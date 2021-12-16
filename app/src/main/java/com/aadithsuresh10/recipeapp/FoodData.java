package com.aadithsuresh10.recipeapp;

public class FoodData {

    private String itemName;
    private String itemDescription;
    private String viewAll;
    private int itemimage;

    public FoodData(String itemName, String itemDescription, String viewAll, int itemimage) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.viewAll = viewAll;
        this.itemimage = itemimage;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getViewAll() {
        return viewAll;
    }

    public int getItemimage() {
        return itemimage;
    }
}

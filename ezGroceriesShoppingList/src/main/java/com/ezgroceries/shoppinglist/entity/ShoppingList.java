package com.ezgroceries.shoppinglist.entity;

public class ShoppingList {

    private String shoppingListId;
    private String name;

    public ShoppingList(String shoppingListId, String name) {
        this.shoppingListId = shoppingListId;
        this.name = name;
    }

    private String[] ingredients;

    public ShoppingList(String shoppingListId, String name, String[] ingredients) {
        this.shoppingListId = shoppingListId;
        this.name = name;
        this.ingredients = ingredients;
    }

    public ShoppingList(String name){
        this.name=name;
    }

    public String getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(String shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }
}

package com.ezgroceries.shoppinglist.util;

import com.ezgroceries.shoppinglist.entity.Cocktail;
import com.ezgroceries.shoppinglist.entity.ShoppingList;

import java.util.List;

public class TestData {

    public static List<Cocktail> getCocktailList() {
        Cocktail firstCocktail = new Cocktail(
                "23b3d85a-3928-41c0-a533-6538a71e17c4",
                "Margerita",
                "Cocktail glass",
                "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten..",
                "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg",
                new String[]{"Tequila",
                        "Triple sec",
                        "Lime juice",
                        "Salt"}
        );
        Cocktail secondCocktail = new Cocktail(
                "d615ec78-fe93-467b-8d26-5d26d8eab073",
                "Blue Margerita",
                "Cocktail glass",
                "Rub rim of cocktail glass with lime juice. Dip rim in coarse salt..",
                "https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg",
                new String[]{"Tequila",
                        "Blue Curacao",
                        "Lime juice",
                        "Salt"}
        );
        return List.of(firstCocktail, secondCocktail);
    }

    public static ShoppingList addCocktailToShoppingList() {
        return new ShoppingList(
                "Test1",
                "Blue Margerita",
                new String[]{"Tequila",
                        "Blue Curacao",
                        "Lime juice",
                        "Salt"});
    }

    public static List<ShoppingList> allShoppingLists() {
        ShoppingList firstShoppingList = new ShoppingList("4ba92a46-1d1b-4e52-8e38-13cd56c7224c",
                "Stephanie's birthday",
                new String[]{
                        "Tequila",
                        "Triple sec",
                        "Lime juice",
                        "Salt",
                        "Blue Curacao"});
        ShoppingList secondShoppingList = new ShoppingList("6c7d09c2-8a25-4d54-a979-25ae779d2465",
                "My Birthday",
                new String[]{
                        "Tequila",
                        "Triple sec",
                        "Lime juice",
                        "Salt",
                        "Blue Curacao"});
        List<ShoppingList> shoppingLists = List.of(firstShoppingList, secondShoppingList);
        return shoppingLists;
    }
}

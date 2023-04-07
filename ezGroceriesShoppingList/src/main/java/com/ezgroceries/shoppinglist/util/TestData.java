package com.ezgroceries.shoppinglist.util;

import com.ezgroceries.shoppinglist.entity.DrinkResource;
import com.ezgroceries.shoppinglist.entity.ShoppingList;
import com.ezgroceries.shoppinglist.repository.CocktailDBResponse;

import java.util.*;

public class TestData {

    public static CocktailDBResponse getCocktailList() {

        DrinkResource drinkResource1=new DrinkResource(
                "11102",
                "Black Russian",
                "Old-fashioned glass",
                "Pour the ingredients into an old fashioned glass filled with ice cubes. Stir gently.",
                "https://www.thecocktaildb.com/images/media/drink/8oxlqf1606772765.jpg",
                "Coffee liqueur",
                "Vodka",
                null
                );
        DrinkResource drinkResource2=new DrinkResource(
                "12528",
                "White Russian",
                "Old-fashioned glass",
                "Pour vodka and coffee liqueur over ice cubes in an old-fashioned glass. Fill with light cream and serve.",
                "https://www.thecocktaildb.com/images/media/drink/vsrupw1472405732.jpg",
                "Vodka",
                "Coffee liqueur",
                "Light cream"
        );
        return new CocktailDBResponse(List.of(drinkResource1,drinkResource2));

    }

    public static ShoppingList getShoppingListWithAddedCocktail() {
        return new ShoppingList(
                "Test1",
                "Blue Margerita",
                new ArrayList(){{
                    add("Tequila");
                        add("Blue Curacao");
                        add("Lime juice");
                        add("Salt");
                }
                }
                );
    }

    public static List<ShoppingList> getAllShoppingLists() {
        ShoppingList firstShoppingList = new ShoppingList("4ba92a46-1d1b-4e52-8e38-13cd56c7224c",
                "Stephanie's birthday",
                new ArrayList(){{
                    add("Tequila");
                    add("Triple sec");
                    add("Blue Curacao");
                    add("Lime juice");
                    add("Salt");
                }
                });
        ShoppingList secondShoppingList = new ShoppingList("6c7d09c2-8a25-4d54-a979-25ae779d2465",
                "My Birthday",
                new ArrayList(){{
                    add("Tequila");
                    add("Triple sec");
                    add("Blue Curacao");
                    add("Lime juice");
                    add("Salt");
                }
                });
        List<ShoppingList> shoppingLists = List.of(firstShoppingList, secondShoppingList);
        return shoppingLists;
    }
}

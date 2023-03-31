package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.entity.Cocktail;
import com.ezgroceries.shoppinglist.entity.ShoppingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShoppingListServiceImpl implements ShoppingListService {

    @Autowired
    private CocktailService cocktailService;


    @Override
    public ShoppingList addCocktailToShoppingList(String shoppingListId, String cocktailId) {
        Cocktail cocktail = cocktailService.findCocktailById(cocktailId);
        ShoppingList shoppingList = findShoppingListById(shoppingListId);
        shoppingList.setIngredients(cocktail.getIngredients());
        return shoppingList;
    }

    @Override
    public ShoppingList findShoppingListById(String shoppingListId) {
        return new ShoppingList(shoppingListId, "Blue Margerita");
    }

    @Override
    public List<ShoppingList> findAllShoppingLists() {
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

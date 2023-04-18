package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.entity.ShoppingList;

import java.util.List;

public interface ShoppingListService {

    ShoppingList addCocktailToShoppingList(String shoppingListId, String cocktailId);

    ShoppingList findShoppingListById(String shoppingListId);

    List<ShoppingList> findAllShoppingLists();


}

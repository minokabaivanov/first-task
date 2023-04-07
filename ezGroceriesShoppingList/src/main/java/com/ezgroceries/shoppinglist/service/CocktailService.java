package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.entity.Cocktail;

public interface CocktailService {

    Cocktail findCocktailById(String cocktailId);
}

package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.entity.Cocktail;

import java.util.List;

public interface CocktailService {

    List<Cocktail> getCocktails(String search);

    Cocktail findCocktailById(String cocktailId);
}

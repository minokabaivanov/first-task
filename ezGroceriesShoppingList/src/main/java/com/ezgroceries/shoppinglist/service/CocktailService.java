package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.entity.Cocktail;

import java.util.List;

public interface CocktailService {

    List<Cocktail> listCocktails(String search);

    Cocktail findCocktailById(String cocktailId);
}

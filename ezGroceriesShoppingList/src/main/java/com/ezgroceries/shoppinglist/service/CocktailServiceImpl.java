package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.entity.Cocktail;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CocktailServiceImpl implements CocktailService {

    @Override
    public List<Cocktail> getCocktails(String search) {
        Cocktail firstCocktail = new Cocktail(
                "23b3d85a-3928-41c0-a533-6538a71e17c4",
                "Margerita",
                "Cocktail glass",
                "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten..",
                "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg",
                new ArrayList() {
                    {
                        add("Tequila");
                        add("Blue Curacao");
                        add("Lime juice");
                        add("Salt");
                    }});
        Cocktail secondCocktail = new Cocktail(
                "d615ec78-fe93-467b-8d26-5d26d8eab073",
                "Blue Margerita",
                "Cocktail glass",
                "Rub rim of cocktail glass with lime juice. Dip rim in coarse salt..",
                "https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg",
                new ArrayList() {
                    {
                        add("Tequila");
                        add("Blue Curacao");
                        add("Lime juice");
                        add("Salt");
                    }});
        List<Cocktail> cocktailList = List.of(firstCocktail, secondCocktail);
        return cocktailList;
    }

    @Override
    public Cocktail findCocktailById(String cocktailId) {
        return new Cocktail(cocktailId,
                "Blue Margerita",
                "Cocktail glass",
                "Rub rim of cocktail glass with lime juice. Dip rim in coarse salt..",
                "https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg",
                new ArrayList() {
                    {
                        add("Tequila");
                        add("Blue Curacao");
                        add("Lime juice");
                        add("Salt");
                    }});
    }
}

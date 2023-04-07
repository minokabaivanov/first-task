package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.entity.Cocktail;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CocktailServiceImpl implements CocktailService {

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
                    }
                });
    }
}

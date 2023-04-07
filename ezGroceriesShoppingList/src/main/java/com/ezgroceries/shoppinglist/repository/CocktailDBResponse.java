package com.ezgroceries.shoppinglist.repository;

import com.ezgroceries.shoppinglist.entity.DrinkResource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CocktailDBResponse {

    private List<DrinkResource> drinks;

    public List<DrinkResource> getDrinks() {
        return drinks;
    }
    public void setDrinks(List<DrinkResource> drinks) {
        this.drinks = drinks;
    }
}

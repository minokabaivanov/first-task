package com.ezgroceries.shoppinglist.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class ShoppingList {

    private String shoppingListId;
    private String name;
    private ArrayList ingredients;

    public ShoppingList(String name) {
        this.name = name;
    }

    public ShoppingList(String shoppingListId, String name) {
        this.shoppingListId = shoppingListId;
        this.name = name;
    }
}

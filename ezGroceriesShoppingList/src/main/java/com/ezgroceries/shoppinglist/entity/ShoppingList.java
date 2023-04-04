package com.ezgroceries.shoppinglist.entity;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class ShoppingList {

    @NotNull(message="field shoppingListId can not be null")
    private String shoppingListId;
    @NotNull(message="field name can not be null")
    private String name;
    private ArrayList ingredients;


    public ShoppingList(String shoppingListId, String name) {
        this.shoppingListId = shoppingListId;
        this.name = name;
    }
}

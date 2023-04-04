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
public class Cocktail {

    private String cocktailId;
    private String name;
    private String glass;
    private String instructions;
    private String image;
    private ArrayList ingredients;// TODO convert to list
}

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
public class Cocktail {

    @NotNull(message="field cocktailId can not be null")
    private String cocktailId;
    @NotNull(message="field name can not be null")
    private String name;
    private String glass;
    private String instructions;
    private String image;
    private ArrayList ingredients;// TODO convert to list
}

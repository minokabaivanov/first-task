package com.ezgroceries.shoppinglist.web;

import com.ezgroceries.shoppinglist.entity.Cocktail;
import com.ezgroceries.shoppinglist.entity.ShoppingList;
import com.ezgroceries.shoppinglist.service.CocktailService;
import com.ezgroceries.shoppinglist.service.ShoppingListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class WebController {

    private static final Logger log = LoggerFactory.getLogger(WebController.class);


    @Autowired
    private CocktailService cocktailService;
    @Autowired
    private ShoppingListService shoppingListService;

    @GetMapping("/cocktails")
    @ResponseBody
    public List<Cocktail> getCocktails(@RequestParam String search) {
        List<Cocktail> cocktails = cocktailService.listCocktails(search);
        log.info("List of cocktails compiled");
        return cocktails;

    }

    @PostMapping("/shopping-list")
    public ResponseEntity<ShoppingList> createShoppingList(@RequestBody ShoppingList shoppingList) {
        log.info("Successfully created a shopping list");
        return buildResponseEntity(shoppingList);
    }

    @GetMapping("/shopping-lists/{shoppingListId}")
    @ResponseBody
    public ShoppingList findShoppingListById(@PathVariable("shoppingListId") String shoppingListId) {
        ShoppingList shoppingList = shoppingListService.findShoppingListById(shoppingListId);
        return shoppingList;
    }

    @PostMapping("/shopping-lists/{shoppingListId}/cocktails")
    public ResponseEntity<ShoppingList> addCocktailToShoppingList(@RequestBody Cocktail cocktail, @PathVariable("shoppingListId") String shoppingListId) {
        String cocktailId = cocktail.getCocktailId();
        ShoppingList shoppingList = shoppingListService.addCocktailToShoppingList(shoppingListId, cocktailId);
        log.info("Successfully added a cocktail " + cocktailId + " to shopping list " + shoppingListId);
        return buildResponseEntity(shoppingList);
    }

    @GetMapping("/shopping-lists")
    @ResponseBody
    public List<ShoppingList> getAllShoppingLists() {
        List<ShoppingList> shoppingLists = shoppingListService.findAllShoppingLists();
        return shoppingLists;

    }

    private ResponseEntity<ShoppingList> buildResponseEntity(ShoppingList shoppingList) {
        String shoppingListString = shoppingList.toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("location", "Placeholder");
        headers.add("created object", shoppingListString);
        return new ResponseEntity<ShoppingList>(headers, HttpStatus.CREATED);
    }
}

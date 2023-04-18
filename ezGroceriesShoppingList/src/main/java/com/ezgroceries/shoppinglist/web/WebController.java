package com.ezgroceries.shoppinglist.web;

import com.ezgroceries.shoppinglist.entity.Cocktail;
import com.ezgroceries.shoppinglist.entity.ShoppingList;
import com.ezgroceries.shoppinglist.service.CocktailService;
import com.ezgroceries.shoppinglist.service.ShoppingListService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class WebController {

    @Autowired
    private CocktailService cocktailService;
    @Autowired
    private ShoppingListService shoppingListService;

    @GetMapping("/cocktails")
    public List<Cocktail> getCocktails(@RequestParam String search) {
        List<Cocktail> cocktails = cocktailService.getCocktails(search);
        log.info("List of cocktails compiled");
        return cocktails;
    }

    @PostMapping("/shopping-list")
    public ResponseEntity<ShoppingList> createShoppingList(@Valid @RequestBody ShoppingList shoppingList) {
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
    public ResponseEntity<ShoppingList> addCocktailToShoppingList(@Valid @RequestBody Cocktail cocktail, @PathVariable("shoppingListId") String shoppingListId) {
        ShoppingList shoppingList = shoppingListService.addCocktailToShoppingList(shoppingListId, cocktail.getCocktailId());
        log.info("Successfully added a cocktail " + cocktail.getCocktailId() + " to shopping list " + shoppingListId);
        return buildResponseEntity(shoppingList);
    }

    @GetMapping("/shopping-lists")
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

package com.ezgroceries.shoppinglist.web;

import com.ezgroceries.shoppinglist.entity.Cocktail;
import com.ezgroceries.shoppinglist.entity.DrinkResource;
import com.ezgroceries.shoppinglist.entity.ShoppingList;
import com.ezgroceries.shoppinglist.repository.CocktailDBResponse;
import com.ezgroceries.shoppinglist.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class WebController {

    private final ShoppingListService shoppingListService;
    private final CocktailDBClient cocktailDBClient;


    @GetMapping("/cocktails")
    public CocktailDBResponse searchCocktails(@RequestParam("search") String search){
        return cocktailDBClient.searchCocktails(search);
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

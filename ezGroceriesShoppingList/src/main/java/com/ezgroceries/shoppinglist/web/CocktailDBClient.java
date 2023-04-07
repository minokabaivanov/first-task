package com.ezgroceries.shoppinglist.web;

import com.ezgroceries.shoppinglist.repository.CocktailDBResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "cocktailDBClient", url = "https://www.thecocktaildb.com/api/json/v1/1")
public interface CocktailDBClient {

    @RequestMapping(method= RequestMethod.GET,value="search.php")
    CocktailDBResponse searchCocktails(@RequestParam("s") String search);
}

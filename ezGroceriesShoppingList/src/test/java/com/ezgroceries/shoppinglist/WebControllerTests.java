package com.ezgroceries.shoppinglist;

import com.ezgroceries.shoppinglist.entity.Cocktail;
import com.ezgroceries.shoppinglist.entity.ShoppingList;
import com.ezgroceries.shoppinglist.service.CocktailServiceImpl;
import com.ezgroceries.shoppinglist.service.ShoppingListService;
import com.ezgroceries.shoppinglist.util.TestData;
import com.ezgroceries.shoppinglist.web.CocktailDBClient;
import com.ezgroceries.shoppinglist.web.WebController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static com.ezgroceries.shoppinglist.util.TestData.getCocktailList;
import static com.ezgroceries.shoppinglist.util.TestData.getShoppingListWithAddedCocktail;
import static com.ezgroceries.shoppinglist.util.TestHelperMethods.resourceToString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WebController.class)
@AutoConfigureMockMvc(addFilters = false)
public class WebControllerTests {


    @MockBean
    private CocktailServiceImpl cocktailService;

    @MockBean
    private CocktailDBClient cocktailDBClient;
    @MockBean
    private ShoppingListService shoppingListService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testListAllCocktails() throws Exception {

        when(cocktailDBClient.searchCocktails(eq("test"))).thenReturn(getCocktailList());

        mockMvc.perform(get("/cocktails?search=test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isMap())
                .andExpect(jsonPath("$.drinks[0].idDrink").value("11102"));

        Mockito.verify(cocktailDBClient, times(1)).searchCocktails("test");
    }


    @Test
    public void testFindShoppingListById() throws Exception {
        String shoppingListId = "Test";
        ShoppingList shoppingList = new ShoppingList(shoppingListId, "Blue Margerita");

        when(shoppingListService.findShoppingListById(shoppingListId)).thenReturn(shoppingList);

        mockMvc.perform(get("/shopping-lists/Test"))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.name").value("Blue Margerita"),
                        jsonPath("$").isMap()
                );
        Mockito.verify(shoppingListService, times(1)).findShoppingListById(shoppingListId);

    }

    @Test
    public void testAddCocktailToShoppingList() throws Exception {
        String shoppingListId = "Test1";
        var contentAsString = resourceToString("/Cocktails.json");

        Mockito.when(shoppingListService.addCocktailToShoppingList("Test1", "23b3d85a-3928-41c0-a533-6538a71e17c4"))
                .thenReturn(getShoppingListWithAddedCocktail());
        mockMvc.perform(post("/shopping-lists/" + shoppingListId + "/cocktails")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(contentAsString))
                .andExpectAll(
                        status().isCreated(),
                        status().is2xxSuccessful()
                );
        Mockito.verify(shoppingListService, times(1)).addCocktailToShoppingList("Test1",
                "23b3d85a-3928-41c0-a533-6538a71e17c4");
    }

    @Test
    public void getAllShoppingLists() throws Exception {

        Mockito.when(shoppingListService.findAllShoppingLists()).thenReturn(TestData.getAllShoppingLists());

        mockMvc.perform(get("/shopping-lists"))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$[0].name").value("Stephanie's birthday"),
                        jsonPath("$[1]").isMap()
                );

        Mockito.verify(shoppingListService, times(1)).findAllShoppingLists();
    }

}

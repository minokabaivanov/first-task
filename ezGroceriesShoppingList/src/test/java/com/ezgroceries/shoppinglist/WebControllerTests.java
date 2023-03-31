package com.ezgroceries.shoppinglist;

import com.ezgroceries.shoppinglist.entity.Cocktail;
import com.ezgroceries.shoppinglist.entity.ShoppingList;
import com.ezgroceries.shoppinglist.service.CocktailServiceImpl;
import com.ezgroceries.shoppinglist.service.ShoppingListService;
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

import java.util.List;

import static com.ezgroceries.shoppinglist.util.TestData.*;
import static com.ezgroceries.shoppinglist.util.TestHelperMethods.resourceToString;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(WebController.class)
@AutoConfigureMockMvc(addFilters = false)
public class WebControllerTests {


    @MockBean
    CocktailServiceImpl cocktailService;

    @MockBean
    ShoppingListService shoppingListService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testListAllCocktails() throws Exception {
        List<Cocktail> cocktailList = getCocktailList();

        when(cocktailService.listCocktails(eq("test"))).thenReturn(cocktailList);

        mockMvc.perform(get("/cocktails?search=test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("Margerita"));

        Mockito.verify(cocktailService, times(1)).listCocktails("test");
    }

    //Ignore the method below. It doesn't do anything. I created it before I realized that there is no direct way to test this method by url
    @Test
    public void testFindCocktailById() {
        String testId = "Test";
        Cocktail testCocktail = new Cocktail(testId,
                "Blue Margerita",
                "Cocktail glass",
                "Rub rim of cocktail glass with lime juice. Dip rim in coarse salt..",
                "https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg",
                new String[]{"Tequila",
                        "Blue Curacao",
                        "Lime juice",
                        "Salt"});

        when(cocktailService.findCocktailById(testId)).thenReturn(testCocktail);
        Mockito.verify(cocktailService, times(0)).findCocktailById(testId);
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
                .thenReturn(addCocktailToShoppingList());
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

        Mockito.when(shoppingListService.findAllShoppingLists()).thenReturn(allShoppingLists());

        mockMvc.perform(get("/shopping-lists"))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$[0].name").value("Stephanie's birthday"),
                        jsonPath("$[1]").isMap()
                );

        Mockito.verify(shoppingListService, times(1)).findAllShoppingLists();
    }

}

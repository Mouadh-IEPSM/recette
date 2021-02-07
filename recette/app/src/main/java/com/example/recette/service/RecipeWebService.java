package com.example.recette.service;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.recette.entity.ListOfRecipeEntity;

/**
 * Created by mouadh on 04-02-21.
 */
public class RecipeWebService {

    /**
     * Instance of retrofit
     */
    private Retrofit retrofit;

    /**
     * instance of Rest Api Interface
     */
    private RecipeServiceInterface recipeServiceInterface;
    /**
     * Constructor
     * Initialise retrofit
     */
    public RecipeWebService(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spoonacular.com/recipes/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        recipeServiceInterface = retrofit.create(RecipeServiceInterface.class);
    }

    /**
     * Method that get all books from the API
     * @return
     */
    public Call<ListOfRecipeEntity> getAllRecipes(String search){
        String apiKey = "b52e21754d4242c8b51678cd2e810595";
        return recipeServiceInterface.getListOfRecipe(apiKey, search);
    }
}

package com.example.recette.service;

import retrofit2.Call;
import com.example.recette.entity.ListOfRecipeEntity;

/**
 * Created by mouadh on 04-02-21.
 */
public class RecipeService{

    RecipeWebService mRecipeWebService;

    /**
     * method that allow to connect to rest API
     * @return enveloppe that content the list of books
     */
    public void connexion(){
        mRecipeWebService = new RecipeWebService();
    }

    public Call<ListOfRecipeEntity> searchRecipesFromAPI(String search){
        if(mRecipeWebService == null)
        {
            connexion();
        }
        return mRecipeWebService.getAllRecipes(search);
    }

}

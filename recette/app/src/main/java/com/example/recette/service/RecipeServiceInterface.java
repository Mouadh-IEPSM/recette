package com.example.recette.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import com.example.recette.entity.ListOfRecipeEntity;

/**
 * Created by mouadh on 04-02-21.
 * Interface that allows to get the list from the webService
 */


public interface RecipeServiceInterface {

    @GET("complexSearch?")
    Call<ListOfRecipeEntity> getListOfRecipe(@Query("apiKey") String apiKey, @Query("query") String query);

}

package com.example.recette.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mouadh on 04-02-21.
 * Entity that represente list of recipe
 */
public class ListOfRecipeEntity {

    /**
     * List of recipe
     */@SerializedName("results")
    private List<RecipeEntity> recipeEntityList;

    /**
     * Get the list of recipe
     * @return all recipe
     */
    public List<RecipeEntity> getListOfRecipe() {
        return recipeEntityList;
    }

    /**
     * setter of the list : change the value of the list
     * @param listOfRecipe : a list of book
     */
    public void setListOfRecipe(List<RecipeEntity> listOfRecipe) {
        this.recipeEntityList = listOfRecipe;
    }
}

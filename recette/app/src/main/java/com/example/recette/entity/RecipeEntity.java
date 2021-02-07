package com.example.recette.entity;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mouadh on 04-02-21.
 * Entity that represente a recipe
 */
public class RecipeEntity implements Serializable {

    /**
     * Id of the recipe
     */
    @SerializedName("id")
    private int id;

    /**
     * Title of the recipe
     */
    @SerializedName("title")
    private String title;

    /**
     * Url of the picture of the recipe
     */
    @SerializedName("image")
    private String image;

    /**
     * getter for the id of the recipe
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * setter for the id of the recipe : using to change the value of id
     * @param id : the id of the recipe
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * the getter of the title of the recipe
     * @return the title of the recipe
     */
    public String getTitle() {
        return title;
    }

    /**
     * the setter of the title of the recipe : using to change the value of title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * getter of the url of the picture of the recipe
     * @return the url
     */
    public String getImage() {
        return image;
    }

    /**
     * the setter of the url of picture of the recipe : using to change the value of url
     * @param image : url of the picture of the recipe
     */
    public void setImage(String image) {
        this.image = image;
    }
}
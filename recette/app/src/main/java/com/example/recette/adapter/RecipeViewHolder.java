package com.example.recette.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recette.R;

/**
 * Created by mouadh on 04-02-21.
 * ViewHolder for recipe
 */
public class RecipeViewHolder extends RecyclerView.ViewHolder {

    /**
     * Image of the recipe
     */
    protected ImageView imageView;
    /**
     * Title of the recipe
     */
    protected TextView textView;

    /**
     * init the cell for a recipe
     * @param view : the view
     */
    public RecipeViewHolder(View view) {
        super(view);
        this.imageView = (ImageView) view.findViewById(R.id.imageOfRecipe);
        this.textView = (TextView) view.findViewById(R.id.titleOfRecipe);
    }
}

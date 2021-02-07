package com.example.recette.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import com.example.recette.R;
import com.example.recette.entity.RecipeEntity;
import com.example.recette.entity.ListOfRecipeEntity;

/**
 * Created by mouadh on 04-02-21.
 * Adapter to display information of recipe
 */
public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    /**
     * list of recipe
     */
    private ListOfRecipeEntity mListOfRecipeEntity;

    /**
     * Context
     */
    private Context mContext;

    public RecipeAdapter(ListOfRecipeEntity listOfRecipeEntity, Context context){
        mListOfRecipeEntity = listOfRecipeEntity;
        mContext = context;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //init the view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_for_recipe, null);
        //init the viewHolder of the cell
        RecipeViewHolder viewHolder = new RecipeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        //get the book
        RecipeEntity recipeEntity = mListOfRecipeEntity.getListOfRecipe().get(position);

        //if the url of picture is not null, we charge it with picasso
        if (!TextUtils.isEmpty(recipeEntity.getImage())) {
            Picasso.with(mContext).load(recipeEntity.getImage())
                    .error(R.drawable.placeholder)
                    .placeholder(R.drawable.placeholder)
                    .into(holder.imageView);
        }

        //Set the title of book
        holder.textView.setText(recipeEntity.getTitle());
    }

    /**
     * get the number of books
     * @return size of the list
     */
    @Override
    public int getItemCount() {
        if ( mListOfRecipeEntity != null &&  mListOfRecipeEntity.getListOfRecipe() != null){
            return mListOfRecipeEntity.getListOfRecipe().size();
        } else {
            return 0;
        }
    }
}

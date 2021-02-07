package com.example.recette;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.recette.adapter.RecipeAdapter;
import com.example.recette.entity.ListOfRecipeEntity;
import com.example.recette.service.RecipeService;

public class MainActivity extends AppCompatActivity {

    /**
     * the recycler view that display the list of recipe
     */
    private RecyclerView mRecyclerView;

    /**
     * the recipe adapter for the view
     */
    private RecipeAdapter mRecipeAdapter;

    private EditText mSearchEditText;

    private Button mButton;

    private String searchText;

    private RecipeService mRecipeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchEditText = (EditText) findViewById(R.id.search_edit_text);
        mButton = (Button) findViewById(R.id.search_button);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecipeService = new RecipeService();
        //set a null adapter to avoid to have an error
        setAdapterToRecyclerView(null);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                searchText = mSearchEditText.getText().toString();
                getRecipeListFromApi();
            }
        });
    }

    private void getRecipeListFromApi() {

        Call<ListOfRecipeEntity> call = mRecipeService.searchRecipesFromAPI(searchText);
        call.enqueue(new Callback<ListOfRecipeEntity>() {
            @Override
            public void onResponse(Call<ListOfRecipeEntity> call, Response<ListOfRecipeEntity> response) {
                ListOfRecipeEntity listOfRecipeEntity = response.body();
                if(listOfRecipeEntity != null)
                {
                    displayBooks(listOfRecipeEntity);
                }
            }

            @Override
            public void onFailure(Call<ListOfRecipeEntity> call, Throwable t) {
                call.cancel();
            }
        });

    }
    public void setAdapterToRecyclerView(ListOfRecipeEntity listOfRecipeEntity){
        mRecipeAdapter = new RecipeAdapter(listOfRecipeEntity,this);
        mRecyclerView.setAdapter(mRecipeAdapter);
    }

    public void displayBooks(ListOfRecipeEntity listOfRecipeEntity){
        setAdapterToRecyclerView(listOfRecipeEntity);
    }
}


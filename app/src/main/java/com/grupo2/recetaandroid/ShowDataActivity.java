package com.grupo2.recetaandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


public class ShowDataActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        
        bindChefs();
        bindRecipes();
    }

    private void bindRecipes(){
        ListView recipesLv = (ListView)findViewById(R.id.recipe_lv);

        RecipeAdapter adapter = new RecipeAdapter(this,R.layout.recipe_item_list);

        List<Recipe> items = RecipeDao.getInstance().getRecipes();

        if(items != null) {
            for(int i=0;i<items.size();i++){
                adapter.add(items.get(i));
            }
        }

        recipesLv.setAdapter(adapter);
    }

    public void bindChefs(){
        ListView chefListView = (ListView) findViewById(R.id.chef_lv);

        ArrayAdapter adapter = new ChefAdapter(this,R.layout.chef_item_list);

        for(Chef chef : ChefDao.getInstance().getChefs())
            adapter.add(chef);

        chefListView.setAdapter(adapter);
    }
}

package com.grupo2.recetaandroid;

import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by blashadow on 3/28/15.
 */
public class RecipeDao {
    private static RecipeDao instance;

    public static synchronized RecipeDao getInstance(){

        if(instance == null){
            instance = new RecipeDao();
        }

        return  instance;
    }

    public boolean createRecipe(Chef itemChef,String recipeName,String imageUrl,int rating){

        Recipe itemRecipe = new Recipe();

        itemRecipe.setChef_id(itemChef.getId());
        itemRecipe.setName(recipeName);
        itemRecipe.setUrlImage(imageUrl);
        itemRecipe.setRating(  rating );

        return itemRecipe.save() > 0;
    }

    public List<Recipe> getRecipes(){

        List<Recipe> result = new Select().from(Recipe.class).execute();

        return result;
    }
}

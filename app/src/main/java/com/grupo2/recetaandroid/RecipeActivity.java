package com.grupo2.recetaandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class RecipeActivity extends ActionBarActivity {

    private EditText recipeNameTxt;
    private EditText imageUrlTxt;
    private Spinner chefRecipeSpn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recipe);

        recipeNameTxt = (EditText)findViewById(R.id.recipe_activity_name);
        chefRecipeSpn = (Spinner)findViewById(R.id.recipe_activity_chef);
        imageUrlTxt = (EditText)findViewById(R.id.recipe_activity_image_url);

        ChefSpinerAdapter adapter = new ChefSpinerAdapter(this,R.layout.chef_spiner_item_list);

        adapter.addAll(ChefDao.getInstance().getChefs());

        chefRecipeSpn.setAdapter(adapter);
    }

    private void message(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void saveRecipe(View v){

        Editable recipeName = recipeNameTxt.getText();

        if(recipeName == null || recipeName.toString().isEmpty()){
            message("El campo nombre es requerido.");
            return;
        }

        Editable imageUrl = imageUrlTxt.getText();

        if(imageUrl == null || imageUrl.toString().isEmpty()){
            message("El campo imagen es requerido.");
            return;
        }

        Chef itemChef = (Chef)chefRecipeSpn.getSelectedItem();

        if(itemChef == null){
            message("Debe seleccionar un chef");
            return;
        }

        boolean result = RecipeDao.getInstance().createRecipe(itemChef,recipeName.toString(),imageUrl.toString(),10);

        if(result){
            message("Receta Creada");
            finish();
        }else{
            message("Error creando receta");
        }
    }
}

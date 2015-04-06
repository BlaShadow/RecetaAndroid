package com.grupo2.recetaandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RecipeActivity extends ActionBarActivity {

    private EditText recipeNameTxt;
    private EditText imageUrlTxt;
    private RatingBar ratingBar;
    private Spinner chefRecipeSpn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recipe);

        recipeNameTxt = (EditText)findViewById(R.id.recipe_activity_name);
        chefRecipeSpn = (Spinner)findViewById(R.id.recipe_activity_chef);
        imageUrlTxt = (EditText)findViewById(R.id.recipe_activity_image_url);
        ratingBar = (RatingBar)findViewById(R.id.recipe_rating_bar);

        ChefSpinerAdapter adapter = new ChefSpinerAdapter(this,R.layout.chef_spiner_item_list);

        for(Chef chef : ChefDao.getInstance().getChefs())
            adapter.add(chef);

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

        Pattern exp = Pattern.compile("^[a-zA-Z0-9äöüÄÖÜ]*$");
        Matcher matcher = exp.matcher(recipeName.toString());

        //Invalid input
        if (matcher.matches() == false)
        {
            message("El nombre contiene caracteres invalidos.");
            return;
        }

        Editable imageUrl = imageUrlTxt.getText();

        if(imageUrl == null || imageUrl.toString().isEmpty()){
            message("El campo imagen es requerido.");
            return;
        }

        //Validate url format :)
        try{
            URL tmpUrl = new URL(imageUrl.toString());
        }catch(MalformedURLException malformedURLException){
            message("Url invalida");
            return;
        }

        Chef itemChef = (Chef)chefRecipeSpn.getSelectedItem();

        if(itemChef == null){
            message("Debe seleccionar un chef");
            return;
        }

        boolean result = RecipeDao.getInstance().createRecipe(itemChef,recipeName.toString(),imageUrl.toString(),(int)ratingBar.getRating());

        if(result){
            message("Receta Creada");
            finish();
        }else{
            message("Error creando receta");
        }
    }

    public void salir(View btn){
        finish();
    }
}

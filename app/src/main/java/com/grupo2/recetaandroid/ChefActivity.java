package com.grupo2.recetaandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ChefActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef);
    }

    public void saveChef(View v){

        EditText nameChef = (EditText)findViewById(R.id.chef_name_txt);

        if(nameChef == null || nameChef.getText() == null ||
                nameChef.getText().toString().isEmpty()){
            message("El nombre del chef es requerido");
            return;
        }

        Pattern exp = Pattern.compile("^[a-zA-Z0-9äöüÄÖÜ]*$");
        Matcher matcher = exp.matcher(nameChef.getText().toString());

        //Invalid input
        if (matcher.matches() == false)
        {
            message("Caracteres invalidos encontrados");
            return;
        }

        nameChef.getText().toString().

        Chef chef = new Chef();
        chef.setName(nameChef.getText().toString());
        chef.save();

        nameChef.setText("");

        message("Chef creado");

        finish();
    }


    private void message(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void salir(View bnt){
        finish();
    }

}

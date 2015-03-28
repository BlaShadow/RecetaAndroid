package com.grupo2.recetaandroid;

import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private final static int SPLASH_TIMEOUT = 3000;

    private ImageButton listBtn = null;
    private ImageButton chefBtn = null;
    private ImageButton recipeBtn = null;
    private ImageButton cancelBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        *   Se muestra primero el layout del splash
        *  */
        setContentView(R.layout.splash);

        /*
        *   Se implementa un CountDownTimer que muestre el view del main
        * */
        new CountDownTimer(SPLASH_TIMEOUT, 1000) {
            public void onFinish() {
                //Se llama al final del ciclo la función que cambia al view del main
                setContentView(R.layout.activity_main);
                initializeButtons();
            }

            public void onTick(long millisUntilFinished) {
                //Pink fluffy unicorns dancing on rainbows
            }
        }.start();

    }

    private void initializeButtons(){
        /*
        *   Método utilizado para inicializar los botones
         */
        this.listBtn = (ImageButton)findViewById(R.id.listBtn);
        this.recipeBtn = (ImageButton)findViewById(R.id.recipeBtn);
        this.chefBtn = (ImageButton)findViewById(R.id.chefBtn);
        this.cancelBtn = (ImageButton)findViewById(R.id.cancelBtn);

        /* Listener de los botones*/
        this.listBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this.getBaseContext(),
                                "Showing list...",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        this.recipeBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this.getBaseContext(),
                                "Adding new recipe...",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        this.chefBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this.getBaseContext(),
                                "Adding new chef...",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        this.cancelBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Bad ending?
                        System.exit(0);
                    }
                }
        );

        /* Fin listener de botones */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.grupo2.recetaandroid;

import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


public class MainActivity extends ActionBarActivity {

    private final static int SPLASH_TIMEOUT = 3000;

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
            }

            public void onTick(long millisUntilFinished) {
                //Pink fluffy unicorns dancing on rainbows
            }
        }.start();

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

package com.grupo2.recetaandroid;

import com.activeandroid.ActiveAndroid;

/**
 * Created by blashadow on 3/28/15.
 */
public class Application  extends com.activeandroid.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}

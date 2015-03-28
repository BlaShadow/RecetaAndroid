package com.grupo2.recetaandroid;

import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by blashadow on 3/28/15.
 */
public class ChefDao {

    private static ChefDao instance;
    private ChefDao(){}

    public synchronized static ChefDao getInstance(){
        if(instance == null){
            instance = new ChefDao();
        }

        return instance;
    }

    public List<Chef> getChefs(){
        return new Select().from(Chef.class).execute();
    }
}

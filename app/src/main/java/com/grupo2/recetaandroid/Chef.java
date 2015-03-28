package com.grupo2.recetaandroid;

/**
 * Created by blashadow on 3/28/15.
 */

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "chef")
public class Chef extends Model {

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


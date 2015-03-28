package com.grupo2.recetaandroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

/**
 * Created by blashadow on 3/28/15.
 */
@Table(name="recipe")
public class Recipe extends Model {

    @Column
    private String name;

    @Column
    private long chef_id;

    @Column
    private String urlImage;

    @Column
    private int rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getChef_id() {
        return chef_id;
    }

    public void setChef_id(long chef_id) {
        this.chef_id = chef_id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Chef getChef(){
        return new Select().from(Chef.class).where("id = ?",this.chef_id).executeSingle();
    }
}

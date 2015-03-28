package com.grupo2.recetaandroid;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by blashadow on 3/28/15.
 */
public class RecipeAdapter extends ArrayAdapter<Recipe> {

    private Context context;

    public RecipeAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootView = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.recipe_item_list, null);

        Recipe item = getItem(position);

        TextView name = (TextView)rootView.findViewById(R.id.recipe_name);
        TextView chefName = (TextView)rootView.findViewById(R.id.recipe_chef_name);
        ImageView image = (ImageView)rootView.findViewById(R.id.recipe_image);

        name.setText(item.getName());
        chefName.setText(item.getChef().getName());

        Log.i("Recipe Adapter", item.getUrlImage());

        Picasso.with(context)
                .load(item.getUrlImage())
                .placeholder(R.mipmap.ic_launcher)
                .resize(50, 50)
                .centerCrop()
                .into(image);

        return  rootView;
    }

}

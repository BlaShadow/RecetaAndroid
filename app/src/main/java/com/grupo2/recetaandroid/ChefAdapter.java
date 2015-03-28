package com.grupo2.recetaandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by blashadow on 3/28/15.
 */
public class ChefAdapter extends ArrayAdapter<Chef> {

    private Context context;

    public ChefAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootView = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.chef_item_list, null);

        Chef item = getItem(position);

        TextView name = (TextView)rootView.findViewById(R.id.chef_name);
        TextView id = (TextView)rootView.findViewById(R.id.chef_id);

        name.setText(item.getName());
        id.setText(item.getId() + "");

        return  rootView;
    }

}


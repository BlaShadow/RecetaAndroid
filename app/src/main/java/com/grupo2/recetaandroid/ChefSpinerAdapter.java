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
public class ChefSpinerAdapter extends ArrayAdapter<Chef> {
    private Context context;

    public ChefSpinerAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
    }

    @Override public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return bindView(position,convertView,parent);
    }


    private View bindView(int position, View convertView, ViewGroup parent){
        View rootView = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.chef_spiner_item_list, null);

        Chef item = getItem(position);

        TextView name = (TextView)rootView.findViewById(R.id.chef_name_spiner_item);

        name.setText(item.getName());

        rootView.setTag(item);

        return  rootView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return bindView(position,convertView,parent);
    }
}

package com.example.ascentacademy_unit_converter_app;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class EntityList {
    final List<Entity> dataset;
    Context context;
    public EntityList(Context context){
        this.context = context;
        dataset = new ArrayList<Entity>();
        dataset.add(new Entity(R.id.textViewMass,R.drawable.weight_24,context.getResources().getString(R.string.mass)));
        dataset.add(new Entity(R.id.textViewTemperature,R.drawable.temp_24,context.getResources().getString(R.string.temp)));
        dataset.add(new Entity(R.id.textViewLength,R.drawable.length_24,context.getResources().getString(R.string.length)));
        dataset.add(new Entity(R.id.textViewTime,R.drawable.alarm_24,context.getResources().getString(R.string.time)));
        dataset.add(new Entity(R.id.textViewData,R.drawable.sd_24,context.getResources().getString(R.string.data)));
    }

    class Entity{
        int id;
        String name;
        int iconId;

        Entity(int id,int iconId, String name){
            this.id = id;
            this.iconId = iconId;
            this.name = name;
        }
    }
}

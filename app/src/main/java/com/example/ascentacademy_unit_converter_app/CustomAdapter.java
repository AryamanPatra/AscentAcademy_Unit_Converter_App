package com.example.ascentacademy_unit_converter_app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    List<String> unitList;
    Context context;

    public CustomAdapter(Context context, List<String> unitList){
        this.unitList = unitList;
    }

    @Override
    public int getCount() {
        return unitList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = new TextView(context);
        TextView tv = (TextView) view;
        tv.setText(unitList.get(i));
        return view;
    }
}

package com.example.ascentacademy_unit_converter_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ascentacademy_unit_converter_app.conversion_classes.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.no_string);
        getSupportActionBar().setElevation(0);
        context = MainActivity.this;
    }

/*
        ON CLICK METHODS
*/
//    changes the entire conversion system
    @SuppressLint("UseCompatLoadingForDrawables")
    public void changeEntity(View view){
        updateScrollBar(view.getId());

//        change calculate icon
        FloatingActionButton fab = findViewById(R.id.calculateConversionFAB);
        fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_android_black_24dp));
    }
//    takes input for the input field
    public void inputMethod(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        EditText inputEd = new EditText(context);
        inputEd.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        final String[] inputText= new String[1];
        builder.setView(inputEd);
        inputEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                inputText[0] = editable.toString();
            }
        });
        builder.setPositiveButton("Insert", (dialogInterface, i) -> {
            TextView tv = findViewById(R.id.input);
            tv.setText(inputText[0]);
        });
        builder.create().show();
    }

/*
        IMPORTANT METHODS
*/

    static int[] scrollBarEntityId = {R.id.textViewMass,R.id.textViewTemperature,R.id.textViewLength,R.id.textViewTime,R.id.textViewData};

//    Updates scroll bar UI on clicking items
    public void updateScrollBar(int id){
        for (int i: scrollBarEntityId){
            TextView textView = findViewById(i);
            Typeface typeface = Typeface.createFromAsset(getAssets(), "res/font/aleo.ttf");
            if(id==i){
                textView.setTextColor(getResources().getColor(R.color.white));
                textView.setTypeface(typeface, Typeface.BOLD);
            }
            else{
                textView.setTextColor(getResources().getColor(R.color.purple_100));
                textView.setTypeface(typeface, Typeface.NORMAL);
            }
        }
    }

}
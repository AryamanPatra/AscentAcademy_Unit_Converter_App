package com.example.ascentacademy_unit_converter_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ascentacademy_unit_converter_app.databinding.ActivityMainBinding;
import com.example.ascentacademy_unit_converter_app.fragments.DataFragment;
import com.example.ascentacademy_unit_converter_app.fragments.LengthFragment;
import com.example.ascentacademy_unit_converter_app.fragments.MassFragment;
import com.example.ascentacademy_unit_converter_app.fragments.TempFragment;
import com.example.ascentacademy_unit_converter_app.fragments.TimeFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    static Context context;
    Fragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.app_name);
        replaceFragment(new MassFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.mass_menu:
                    replaceFragment(new MassFragment());
                    break;
                case R.id.temp_menu:
                    replaceFragment(new TempFragment(context));
                    break;
                case R.id.length_menu:
                    replaceFragment(new LengthFragment());
                    break;
                case R.id.time_menu:
                    replaceFragment(new TimeFragment());
                    break;
                case R.id.data_menu:
                    replaceFragment(new DataFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }

    public static AlertDialog createBuilder(TextView inputTextView){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        EditText editText = new EditText(context);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        builder.setView(editText);
        builder.setTitle("Input");
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                inputTextView.setText(editText.getText());
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }
}
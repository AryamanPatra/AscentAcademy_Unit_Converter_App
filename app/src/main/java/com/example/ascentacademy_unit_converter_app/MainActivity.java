package com.example.ascentacademy_unit_converter_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.app_name);
        replaceFragement(new MassFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.mass_menu:
                    replaceFragement(new MassFragment());
                    break;
                case R.id.temp_menu:
                    replaceFragement(new TempFragment());
                    break;
                case R.id.length_menu:
                    replaceFragement(new LengthFragment());
                    break;
                case R.id.time_menu:
                    replaceFragement(new TimeFragment());
                    break;
                case R.id.data_menu:
                    replaceFragement(new DataFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragement(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}
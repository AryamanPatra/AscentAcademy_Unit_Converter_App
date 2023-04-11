package com.example.ascentacademy_unit_converter_app.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ascentacademy_unit_converter_app.MainActivity;
import com.example.ascentacademy_unit_converter_app.R;
import com.example.ascentacademy_unit_converter_app.conversion_classes.ConversionScale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MassFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MassFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MassFragment() {
        // Required empty public constructor
    }
    public MassFragment(Context context){
        this.context = context;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MassFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MassFragment newInstance(String param1, String param2) {
        MassFragment fragment = new MassFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mass, container, false);
    }


    Context context;
    HashMap<TextView,ConversionScale.MassScale> selectionContainer = new HashMap<>();
    TextView inputField,outputField,inputUnit,outputUnit;
    TextView chosenField;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        inputField = requireView().findViewById(R.id.massConvertFrom);
        outputField = requireView().findViewById(R.id.massConvertTo);
        inputUnit = requireView().findViewById(R.id.massUnitFrom);
        outputUnit = requireView().findViewById(R.id.massUnitTo);
        Button calculate = requireView().findViewById(R.id.massCalculate);

        selectionContainer.put(inputField,ConversionScale.MassScale.G);
        selectionContainer.put(outputField,ConversionScale.MassScale.KG);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                      CALCULATION ALGO
                ConversionScale.MassScale unitFrom = selectionContainer.get(inputField);
                ConversionScale.MassScale unitTo = selectionContainer.get(outputField);
                assert unitFrom != null;
                assert unitTo != null;
                double multiplier = unitFrom.scaleValue/unitTo.scaleValue;
                double inputValue = Double.parseDouble(inputField.getText().toString());
                outputField.setText(String.valueOf(inputValue*multiplier));
            }
        });
        inputField.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = MainActivity.createBuilder(inputField);
                builder.create().show();
                return true;
            }
        });

        View.OnClickListener visualSelection = new View.OnClickListener() {
            @SuppressLint({"UseCompatLoadingForDrawables", "NonConstantResourceId"})
            @Override
            public void onClick(View view) {
                onClickField(view);
            }
        };
        View.OnClickListener unitSelection = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                onClickField(view);
                AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                ConversionScale.MassScale[] massScaleArray;
                massScaleArray = ConversionScale.MassScale.values();
                ArrayAdapter<ConversionScale.MassScale> ad = new ArrayAdapter<>(getContext(),android. R. layout. simple_list_item_1,massScaleArray);
                ListView listView = new ListView(getContext());
                listView.setAdapter(ad);
                builder.setView(listView);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view1, int i, long l) {
                        String value = (String)((TextView)view1).getText();
                        ((TextView) view).setText(value);
                        for(ConversionScale.MassScale ms:massScaleArray){
                            if(ms.toString().equals(value)){
                                selectionContainer.put(chosenField,ms);
                                break;
                            }
                        }
                    }
                });
                builder.setPositiveButton("Set", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create().show();
            }
        };

        inputField.setOnClickListener(visualSelection);
        outputField.setOnClickListener(visualSelection);
        inputUnit.setOnClickListener(unitSelection);
        outputUnit.setOnClickListener(unitSelection);
    }

    void onClickField(View view){
        switch (view.getId()) {
            case R.id.massConvertTo:
            case R.id.massUnitTo:
                chosenField = outputField;
                outputField.setBackground(requireContext().getDrawable(R.drawable.textview_border_selected));
                outputUnit.setBackground(requireContext().getDrawable(R.drawable.textview_border_selected));
                inputField.setBackground(requireContext().getDrawable(R.drawable.textview_border_unselected));
                inputUnit.setBackground(requireContext().getDrawable(R.drawable.textview_border_unselected));
                break;
            case R.id.massConvertFrom:
            case R.id.massUnitFrom:
                chosenField = inputField;
                inputField.setBackground(requireContext().getDrawable(R.drawable.textview_border_selected));
                inputUnit.setBackground(requireContext().getDrawable(R.drawable.textview_border_selected));
                outputField.setBackground(requireContext().getDrawable(R.drawable.textview_border_unselected));
                outputUnit.setBackground(requireContext().getDrawable(R.drawable.textview_border_unselected));
                break;
        }
    }
}
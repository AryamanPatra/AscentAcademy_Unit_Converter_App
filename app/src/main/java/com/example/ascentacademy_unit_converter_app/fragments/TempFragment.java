package com.example.ascentacademy_unit_converter_app.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ascentacademy_unit_converter_app.conversion_classes.ConversionScale;
import com.example.ascentacademy_unit_converter_app.R;

import java.util.HashMap;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TempFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TempFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Context context;

    public TempFragment() {
        // Required empty public constructor
    }
    public TempFragment(Context context) {
        this.context = context;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TempFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TempFragment newInstance(String param1, String param2) {
        TempFragment fragment = new TempFragment();
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
        return inflater.inflate(R.layout.fragment_temp, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        inputField = requireView().findViewById(R.id.tempConvertFrom);
        outputField = requireView().findViewById(R.id.tempConvertTo);
        selectionContainer.put(inputField,selectedTemp);
        selectionContainer.put(outputField,selectedTemp);

        View.OnClickListener fieldListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickField(view);
            }
        };
        if(inputField!=null && outputField!=null){
            inputField.setOnClickListener(fieldListener);
            outputField.setOnClickListener(fieldListener);
        }
        else
            Toast.makeText(context, "Bummer", Toast.LENGTH_SHORT).show();

        buttonTempArr[0] = requireView().findViewById(R.id.tempUnitCel);
        buttonTempArr[1] = requireView().findViewById(R.id.tempUnitFarh);
        buttonTempArr[2] = requireView().findViewById(R.id.tempUnitKel);
        View.OnClickListener tempListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickTemp(view);
            }
        };
        for(int i=0; i<3; i++){
            buttonTempArr[i].setOnClickListener(tempListener);
        }
    }

//    Methods and codes
    TextView inputField;
    TextView outputField;
    TextView chosenField;
    HashMap<TextView,String> selectionContainer = new HashMap<TextView,String>();
    Button[] buttonTempArr = new Button[3];
    String selectedTemp = "";

    public void onClickField(View view){
        switch (view.getId()){
            case R.id.tempConvertTo:
                chosenField = outputField;
                outputField.setBackground(getContext().getDrawable(R.drawable.textview_border_selected));
                inputField.setBackground(getContext().getDrawable(R.drawable.textview_border_unselected));
                break;
            case R.id.tempConvertFrom:
                chosenField = inputField;
                inputField.setBackground(getContext().getDrawable(R.drawable.textview_border_selected));
                outputField.setBackground(getContext().getDrawable(R.drawable.textview_border_unselected));
                break;
        }
        selectTemp(selectionContainer.get(chosenField));
        Toast.makeText(context, selectionContainer.get(chosenField), Toast.LENGTH_SHORT).show();
    }

    public void onClickTemp(View view){
        selectedTemp = ((Button)view).getText().toString();
        selectionContainer.put(chosenField,selectedTemp);
        selectTemp(selectedTemp);
    }

    void selectTemp(String s){
        for(Button b:buttonTempArr){
            if(b.getText().equals(s))
                b.setBackgroundColor(getContext().getColor(R.color.purple_500));
            else
                b.setBackgroundColor(getContext().getColor(R.color.grey));
        }
    }

}
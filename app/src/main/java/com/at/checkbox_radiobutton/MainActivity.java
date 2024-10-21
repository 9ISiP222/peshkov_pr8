package com.at.checkbox_radiobutton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.CompoundButton;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RadioGroup radgrp = findViewById(R.id.radioGroup);
        radgrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                TextView selection2 = findViewById(R.id.textView3);
                if(i==R.id.radioButton){
                    selection2.setText("Выбрали завтрак:омлет, салат Цезарь, сок малиновый");

                }
                if(i==R.id.radioButton2){
                    selection2.setText("Выбрали обед: гренки, каша овсяная,кофе баз сахара");

                }
                if(i==R.id.radioButton3){
                    selection2.setText("Выбрали ужин:борщ с бараниной, винегрет, морс ежевичный натуральный");
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @SuppressLint("ResourceAsColor")
    public void onCheckboxClicked(View view) {

        CheckBox checkBox = (CheckBox) view;

        TextView textView = findViewById(R.id.textView);
        if (checkBox.isChecked()) {
            checkBox.setBackgroundResource(android.R.color.black);
            textView.setText("Включено");
            checkBox.setText("Выключить");

        } else {
            checkBox.setBackgroundResource(android.R.color.white);
            textView.setText("Выключено");
            checkBox.setText("Включить");

        }
    }

    public void onCheckboxClicked2(View view) {
//        CheckBox checkBox = (CheckBox) view;
//
//        boolean checked = checkBox.isChecked();
//
//        TextView selection = findViewById(R.id.selection);
//
//        switch(view.getId()) {
//            case R.id.java:
//                if(checked)
//                    Toast.makeText(this, "Вы выбрали Java", Toast.LENGTH_LONG).show();
//                break;
//            case R.id.kotlin:
//                if (checked)
//                    Toast.makeText(this, "Вы выбрали kotlin",Toast.LENGTH_LONG).show();
//                break;
//
//            default:
//                selection.setText("");
//        }
        CheckBox language = (CheckBox) view;
        TextView selection = findViewById(R.id.selection);
        if (language.isChecked())
            selection.setText(language.getText());

        CheckBox java = findViewById(R.id.java);
        CheckBox kotlin = findViewById(R.id.kotlin);
        String selectionItem = "";
        if (java.isChecked())
            selectionItem += java.getText() + "";
        if (kotlin.isChecked())
            selectionItem += kotlin.getText();

        selection = (TextView) findViewById(R.id.selection);
        selection.setText(selectionItem);
    }

    @SuppressLint("SetTextI18n")
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton)view).isChecked();
        TextView textView3 = findViewById(R.id.textView3);
        if(view.getId()== R.id.radioButton){
            if (checked){
                textView3.setText("Выбрали завтрак:омлет, салат Цезарь, сок малиновый");
            }
        }
        if (view.getId()==R.id.radioButton2){
            if(checked){
                textView3.setText("Выбрали обед: гренки, каша овсяная,кофе баз сахара");
            }
        }
        if(view.getId()==R.id.radioButton3){
            if(checked){
                textView3.setText("Выбрали ужин:борщ с бараниной, винегрет, морс ежевичный натуральный");
            }
          }

        }
    }






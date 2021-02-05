package com.example.projetand;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AddActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    final Fragment club = new FragmentAddClub();
    final Fragment site = new FragmentAddSite();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        final TextView addchoice = (TextView) findViewById(R.id.addchoice);

        findViewById(R.id.radioclub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.layout, club);
                fragmentTransaction.commit();
                addchoice.setVisibility(View.INVISIBLE);
            }
        });
        findViewById(R.id.radiosite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.layout, site);
                fragmentTransaction.commit();
                addchoice.setVisibility(View.INVISIBLE);
            }
        });
    }
}
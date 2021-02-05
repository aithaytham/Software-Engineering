package com.example.projetand;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SitesActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sites);


        SimpleAdapter adapter = new SimpleAdapter(generateSimpleList());
        RecyclerView recyclerView = findViewById(R.id.simple_recyclerview2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        Button bt1 = findViewById(R.id.addcomment2);
        bt1.setOnClickListener(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("Site");



        TextView namesite,localisationsite,descriptionsite;
        RatingBar ratbarfaunesite,ratbarfloresite;
        namesite=(TextView)findViewById(R.id.textView6);
        localisationsite=(TextView)findViewById(R.id.textView7);
        descriptionsite=(TextView)findViewById(R.id.textView9);
        ratbarfaunesite = (RatingBar)findViewById(R.id.ratingBar4);
        ratbarfloresite = (RatingBar)findViewById(R.id.ratingBar5);


        namesite.setText(listsite.getNamesites());
        localisationsite.setText(listsite.getLocalisationsites());
        descriptionsite.setText(listsite.getDescriptionsites());
        ratbarfloresite.setRating(listsite.getNoteflores());
        ratbarfaunesite.setRating(listsite.getNotefaunes());

    }

    public void onClick(View v) {
        if (v.getId() == R.id.addcomment2) {

        }
    }

    private List<SimpleViewModel> generateSimpleList () {
        List<SimpleViewModel> simpleViewModelList = new ArrayList<>();

        simpleViewModelList.add(new SimpleViewModel(String.format(Locale.US, "This is comment %d", 1)));

        //simpleViewModelList.add(new SimpleViewModel(comment));

        return simpleViewModelList;
    }

}


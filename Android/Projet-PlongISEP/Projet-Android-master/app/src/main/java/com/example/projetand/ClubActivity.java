package com.example.projetand;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



public class ClubActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        SimpleAdapter adapter = new SimpleAdapter(generateSimpleList());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.simple_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Button bt1 = findViewById(R.id.addcomment);
        bt1.setOnClickListener((View.OnClickListener) this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("Club");



        TextView nameclub,localisationclub,descriptionclub,typeclub;
        RatingBar ratbarclub;
        nameclub=(TextView)findViewById(R.id.nomduclub);
        localisationclub=(TextView)findViewById(R.id.locclub);
        descriptionclub=(TextView)findViewById(R.id.descriptionclub);
        typeclub = (TextView) findViewById(R.id.typeclub);
        ratbarclub = (RatingBar)findViewById(R.id.ratbarclub);

        //static problem
        //DataSnapshot dataSnapshot = null;
        //listclub listclub = dataSnapshot.getValue(listclub.class);
        //Log.d(TAG, "User name: " + listclub.getName());
        nameclub.setText(listclub.getNamec());
        localisationclub.setText(listclub.getLocalisationc());
        descriptionclub.setText(listclub.getDescriptionc());
        typeclub.setText(listclub.getTypec());
        ratbarclub.setRating(listclub.getNotec());




    }

    public void onClick(View v) {
        if (v.getId() == R.id.addcomment) {

        }
    }

        private List<SimpleViewModel> generateSimpleList () {
            List<SimpleViewModel> simpleViewModelList = new ArrayList<>();

            simpleViewModelList.add(new SimpleViewModel(String.format(Locale.US, "Comment %d", 1)));
            //simpleViewModelList.add(new SimpleViewModel(comment));

            return simpleViewModelList;
        }

    }


package com.example.projetand;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.jar.Attributes;


public class FragmentAddClub extends Fragment {
EditText txtname,txtdescription,txtlocalisation;
RatingBar ratingBar;
RadioGroup type;
listclub listclub;
    private static final String TAG = "MainActivity";

final static int[] i = {0};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_add_club, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Ajouter un club");
        final Button valider = getActivity().findViewById(R.id.button2);
        txtname=(EditText)getActivity().findViewById(R.id.nomclub);
        txtdescription=(EditText)getActivity().findViewById(R.id.descriptionclub);
        txtlocalisation=(EditText)getActivity().findViewById(R.id.localisationclub);
        type=(RadioGroup)getActivity().findViewById(R.id.radioGroup4);
        ratingBar=(RatingBar)getActivity().findViewById(R.id.ratingBar3);
        listclub=new listclub();


        valider.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                i[0] = i[0] +1;
                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference().child("Club");
                int slctrdbtnid = type.getCheckedRadioButtonId();
                RadioButton slctrdbtn = (RadioButton) getActivity().findViewById(slctrdbtnid);
                String slctrdbtntxt = slctrdbtn.getText().toString().trim();
                listclub.setName(txtname.getText().toString().trim());
                com.example.projetand.listclub.setNamec(txtname.getText().toString().trim());
                listclub.setDescription(txtdescription.getText().toString().trim());
                listclub.setDescriptionc(txtdescription.getText().toString().trim());
                listclub.setLocalisation(txtlocalisation.getText().toString().trim());
                listclub.setLocalisationc(txtlocalisation.getText().toString().trim());
                listclub.setType(slctrdbtntxt);
                listclub.setTypec(slctrdbtntxt);
                listclub.setId(i[0]);
                listclub.setIdc(i[0]);
                float getrating = ratingBar.getRating();
                listclub.setNote(getrating);
                listclub.setNotec(getrating);
                //String c = myRef.child("Club").getSpec(Query.limitToFirst() );
                //.replaceAll("[^0-9]","");
//                i[0]=Integer.parseInt(c);
           //     Log.i(TAG,"------------------------"+c);
                myRef.child("Club"+ i[0]).setValue(listclub);
                getActivity().finish();

            }
        });
    }

}
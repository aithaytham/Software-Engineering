package com.example.projetand;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class FragmentAddSite extends Fragment {
    EditText txtnamesite,txtdescriptionsite,txtlocalisationsite;
    RatingBar rtbfaune,rtbflore;
    CheckBox txtexploration,txtenseignement,txtdepartBord,txtdepartBateau,txtepave,txtnuit;
    listsite listsite;
    final static int[] j = {0};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_add_site, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Ajouter un site");
        Button validersite = getActivity().findViewById(R.id.validersite);
        txtnamesite=(EditText)getActivity().findViewById(R.id.Name);
        txtdescriptionsite=(EditText)getActivity().findViewById(R.id.description);
        txtlocalisationsite=(EditText)getActivity().findViewById(R.id.localisationsite);
        txtexploration=(CheckBox) getActivity().findViewById(R.id.exploration);
        txtenseignement=(CheckBox)getActivity().findViewById(R.id.enseignement);
        txtdepartBord=(CheckBox)getActivity().findViewById(R.id.departbord);
        txtdepartBateau=(CheckBox)getActivity().findViewById(R.id.departbateau);
        txtepave=(CheckBox)getActivity().findViewById(R.id.epave);
        txtnuit=(CheckBox)getActivity().findViewById(R.id.nuit);
        rtbflore=(RatingBar)getActivity().findViewById(R.id.ratingBarflore);
        rtbfaune=(RatingBar)getActivity().findViewById(R.id.ratingBarfaune);
        listsite=new listsite();

        validersite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                j[0] = j[0] + 1;
                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference().child("Site");
                listsite.setNamesite(txtnamesite.getText().toString().trim());
                listsite.setDescriptionsite(txtdescriptionsite.getText().toString().trim());
                listsite.setLocalisationsite(txtlocalisationsite.getText().toString().trim());
                listsite.setNamesites(txtnamesite.getText().toString().trim());
                listsite.setDescriptionsites(txtdescriptionsite.getText().toString().trim());
                listsite.setLocalisationsites(txtlocalisationsite.getText().toString().trim());
                if (txtexploration.isChecked()){
                    listsite.setExplorationsite(txtexploration.getText().toString().trim());
                    listsite.setExplorationsites(txtexploration.getText().toString().trim());
                }
                if (txtenseignement.isChecked()){
                listsite.setEnseignementsite(txtenseignement.getText().toString().trim());
                    listsite.setEnseignementsites(txtenseignement.getText().toString().trim());
                }
                if (txtdepartBord.isChecked()){
                listsite.setDepartBordsite(txtdepartBord.getText().toString().trim());
                    listsite.setDepartBordsites(txtdepartBord.getText().toString().trim());}
                if (txtdepartBateau.isChecked()){
                listsite.setDepartBateausite(txtdepartBateau.getText().toString().trim());
                    listsite.setDepartBateausites(txtdepartBateau.getText().toString().trim());}
                if (txtepave.isChecked()){
                listsite.setEpavesite(txtepave.getText().toString().trim());
                    listsite.setEpavesites(txtepave.getText().toString().trim());}
                if (txtnuit.isChecked()){
                listsite.setNuitsite(txtnuit.getText().toString().trim());
                    listsite.setNuitsites(txtnuit.getText().toString().trim());}
                float getratingfaune = rtbfaune.getRating();
                listsite.setNotefaune(getratingfaune);
                listsite.setNotefaunes(getratingfaune);
                float getratingflore = rtbflore.getRating();
                listsite.setNoteflore(getratingflore);
                listsite.setNoteflores(getratingflore);
                listsite.setId(j[0]);
                listsite.setIds(j[0]);
                myRef.child("Site" + j[0]).setValue(listsite);
                getActivity().finish();

            }
        });
    }
}
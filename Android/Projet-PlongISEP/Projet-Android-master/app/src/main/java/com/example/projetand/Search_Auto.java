package com.example.projetand;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

public class Search_Auto extends AppCompatActivity {

    String apiKey;
    private PlacesClient placesClient;
    private static final String TAG = "MainActivity";
    listclub listclub;
    final static int[] i = {5};

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        apiKey = "AIzaSyCKjuzXd45S-1Zshi3JCd7hGQ3bChgog6E";
        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), apiKey);
        }
        placesClient = Places.createClient(this);

        final AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_support_fragments);
        listclub=new listclub();

// Specify the types of place data to return.



        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

// Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference().child("Club");
                i[0] = i[0] +1;
                listclub.setId(i[0]);
                listclub.setName(place.getName());
                listclub.setDescription(place.getPhoneNumber());
                listclub.setLocalisation(place.getAddress());
                //    Log.i(TAG, "--------------------: " + listclub.getName() + ", " + listclub.getId());
                if(place.getUserRatingsTotal()!=null){
                    listclub.setNote(place.getUserRatingsTotal());

                }
                Log.i(TAG, "Place: " + place.getName() + ", " + listclub.getLocalisation() + ", " + listclub.getDescription()+ ","+place.getAddress());

                myRef.child("Club"+i[0]).setValue(listclub);
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }

        });
    }
}

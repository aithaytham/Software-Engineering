package com.example.projetand;

import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Arrays;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private static final int RC_SIGN_IN = 123;
    private FirebaseAuth mAuth;
    String apiKey;
    private PlacesClient placesClient;
    private static final String TAG = "MainActivity";

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 4 - Handle SignIn Activity response on activity result
        this.handleResponseAfterSignIn(requestCode, resultCode, data);
    }

    private void showSnackBar(DrawerLayout coordinatorLayout, String message) {
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    private void handleResponseAfterSignIn(int requestCode, int resultCode, Intent data) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        IdpResponse response = IdpResponse.fromResultIntent(data);

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) { // SUCCESS
                showSnackBar(drawer, getString(R.string.connection_succeed));
            } else { // ERRORS
                if (response == null) {
                    showSnackBar(drawer, getString(R.string.error_authentication_canceled));
                } else if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {
                    showSnackBar(drawer, getString(R.string.error_no_internet));
                } else if (response.getError().getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                    showSnackBar(drawer, getString(R.string.error_unknown_error));
                }
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
         apiKey = "AIzaSyCKjuzXd45S-1Zshi3JCd7hGQ3bChgog6E";

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ajouter un site ou un club", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(view.getContext(), AddActivity.class);
                view.getContext().startActivity(intent);

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Button connexion_btn = findViewById(R.id.connexion_button);
        //connexion_btn.setOnClickListener(this);

        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), apiKey);
        }
        placesClient = Places.createClient(this);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //return true;
        //}

        return super.onOptionsItemSelected(item);
    }/*
    public void setupAutocompleteSupportFragment() {
// Initialize the AutocompleteSupportFragment.
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_support_fragment);

// Specify the types of place data to return.



        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

// Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }

        });

    }*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;

        int id = item.getItemId();

        switch (id) {
            case R.id.nav_camera:
                    new MonnCompte();
                Intent intent = new Intent(this, MonnCompte.class);
                startActivity(intent);

                 //     fragment = new MonCompte();
                break;
            case R.id.nav_recherche:
                //fragment = new Recherche();
                Intent intents = new Intent(this, Search_Auto.class);
                startActivity(intents);
                if((this.getCurrentUser())!= null){
                    String email = TextUtils.isEmpty(this.getCurrentUser().getEmail()) ? getString(R.string.info_no_email_found) : this.getCurrentUser().getEmail();
                    String username = TextUtils.isEmpty(this.getCurrentUser().getDisplayName()) ? getString(R.string.info_no_username_found) : this.getCurrentUser().getDisplayName();

                    TextView userNameView = findViewById(R.id.username);
                    userNameView.setText(username);
                    TextView emailView = findViewById(R.id.textView);
                    emailView.setText(email);
                }
                else
                {
                    TextView userNameView = findViewById(R.id.username);
                    userNameView.setText("Nom utilisateur");
                    TextView emailView = findViewById(R.id.textView);
                    emailView.setText("utilisateur@mail.com");
                }
                break;
            case R.id.nav_gallery:
                fragment = new Club();
                if((this.getCurrentUser())!= null){
                    String email = TextUtils.isEmpty(this.getCurrentUser().getEmail()) ? getString(R.string.info_no_email_found) : this.getCurrentUser().getEmail();
                    String username = TextUtils.isEmpty(this.getCurrentUser().getDisplayName()) ? getString(R.string.info_no_username_found) : this.getCurrentUser().getDisplayName();

                    TextView userNameView = findViewById(R.id.username);
                    userNameView.setText(username);
                    TextView emailView = findViewById(R.id.textView);
                    emailView.setText(email);
                }
                else
                {
                    TextView userNameView = findViewById(R.id.username);
                    userNameView.setText("Nom utilisateur");
                    TextView emailView = findViewById(R.id.textView);
                    emailView.setText("utilisateur@mail.com");
                }
                break;
            case R.id.nav_slideshow:
                fragment = new Sites();
                if((this.getCurrentUser())!= null){
                    String email = TextUtils.isEmpty(this.getCurrentUser().getEmail()) ? getString(R.string.info_no_email_found) : this.getCurrentUser().getEmail();
                    String username = TextUtils.isEmpty(this.getCurrentUser().getDisplayName()) ? getString(R.string.info_no_username_found) : this.getCurrentUser().getDisplayName();

                    TextView userNameView = findViewById(R.id.username);
                    userNameView.setText(username);
                    TextView emailView = findViewById(R.id.textView);
                    emailView.setText(email);
                }
                else
                {
                    TextView userNameView = findViewById(R.id.username);
                    userNameView.setText("Nom utilisateur");
                    TextView emailView = findViewById(R.id.textView);
                    emailView.setText("utilisateur@mail.com");
                }
                break;
            case R.id.nav_manage:
                fragment = new Contact();
                if((this.getCurrentUser())!= null){
                    String email = TextUtils.isEmpty(this.getCurrentUser().getEmail()) ? getString(R.string.info_no_email_found) : this.getCurrentUser().getEmail();
                    String username = TextUtils.isEmpty(this.getCurrentUser().getDisplayName()) ? getString(R.string.info_no_username_found) : this.getCurrentUser().getDisplayName();

                    TextView userNameView = findViewById(R.id.username);
                    userNameView.setText(username);
                    TextView emailView = findViewById(R.id.textView);
                    emailView.setText(email);
                }
                else
                {
                    TextView userNameView = findViewById(R.id.username);
                    userNameView.setText("Nom utilisateur");
                    TextView emailView = findViewById(R.id.textView);
                    emailView.setText("utilisateur@mail.com");
                }
                break;
            case R.id.nav_inscription:
                //fragment = new MonnCompte();

                startSignInActivity();
                if((this.getCurrentUser())!= null){
                    String email = TextUtils.isEmpty(this.getCurrentUser().getEmail()) ? getString(R.string.info_no_email_found) : this.getCurrentUser().getEmail();
                    String username = TextUtils.isEmpty(this.getCurrentUser().getDisplayName()) ? getString(R.string.info_no_username_found) : this.getCurrentUser().getDisplayName();

                    TextView userNameView = findViewById(R.id.username);
                    userNameView.setText(username);
                    TextView emailView = findViewById(R.id.textView);
                    emailView.setText(email);
                }
                else
                {
                    TextView userNameView = findViewById(R.id.username);
                    userNameView.setText("Nom utilisateur");
                    TextView emailView = findViewById(R.id.textView);
                    emailView.setText("utilisateur@mail.com");
                }
                break;

        }


        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }


        /*if (id == R.id.nav_camera) {
            startActivity(new Intent(this, CompteActivity.class));
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(this, ClubActivity.class));
        } else if (id == R.id.nav_slideshow) {
            startActivity(new Intent(this, SitesActivity.class));
        } else if (id == R.id.nav_manage) {
            startActivity(new Intent(this, ContactActivity.class));
        } else if (id == R.id.nav_recherche) {

        }
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
     //   if (this.isCurrentUserLogged()){
       //     this.startProfileActivity();
     //   } else {
            this.startSignInActivity();
        //}
    }

    protected void onResume() {
        super.onResume();
        // 5 - Update UI when activity is resuming
    //    this.updateUIWhenResuming();
    }

    private void startSignInActivity() {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setTheme(R.style.LoginTheme)
                        .setAvailableProviders(
                                Arrays.asList(new AuthUI.IdpConfig.EmailBuilder().build(),
                                        new AuthUI.IdpConfig.GoogleBuilder().build()))
                        .setIsSmartLockEnabled(false, true)
                        .setLogo(R.drawable.connexion)
                        .build(),
                RC_SIGN_IN);
   }

    // 3 - Launching Profile Activity
    private void startProfileActivity() {
        Intent intent = new Intent(this, MonnCompte.class);
        startActivity(intent);
    }

    protected FirebaseUser getCurrentUser(){ return FirebaseAuth.getInstance().getCurrentUser(); }

    protected Boolean isCurrentUserLogged(){ return (this.getCurrentUser() != null); }
    // 2 - Update UI when activity is resuming
    private void updateUIWhenResuming() {
      //MenuItem inscription = findViewById(R.id.nav_inscription);
    //  CharSequence a = this.isCurrentUserLogged() ? getString(R.string.button_login_text_logged) : getString(R.string.button_login_text_not_logged).toString();
      //  inscription.setTitle(a);
    }
}

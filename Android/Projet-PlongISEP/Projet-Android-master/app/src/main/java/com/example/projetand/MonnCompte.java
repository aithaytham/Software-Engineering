package com.example.projetand;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.projetand.R;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.annotations.Nullable;

import android.app.Activity;
import butterknife.ButterKnife;
import butterknife.BindView;
import butterknife.OnClick;


public class MonnCompte extends AppCompatActivity {
    private static final int SIGN_OUT_TASK = 10;
    private static final int DELETE_USER_TASK = 20;
    ImageView imageViewProfile ;
    EditText textInputEditTextUsername ;
    TextView textViewEmail  ;
    ProgressBar progressBar  ;
  //  Button button_Update;
    Button button_SignOut;
    Button button_Delete;
    TextView userNameView;
    TextView emailView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.configureToolbar();
        setContentView(R.layout.activity_profile);

        imageViewProfile=findViewById(R.id.profile_activity_imageview_profile);
        textInputEditTextUsername = findViewById(R.id.profile_activity_edit_text_username) ;
        textViewEmail = findViewById(R.id.profile_activity_text_view_email) ;
        progressBar = findViewById(R.id.profile_activity_progress_bar) ;
        //button_Update = findViewById(R.id.profile_activity_button_update);
        button_Delete=findViewById(R.id.profile_activity_button_delete);
        button_SignOut=findViewById(R.id.profile_activity_button_sign_out);

     /*   button_Update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }

        });*/
        button_Delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onClickDeleteButton();
            }

        });
        button_SignOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                signOutUserFromFirebase();
            }

        });

        updateUIWhenCreating();
    }
    protected void configureToolbar(){
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }


    public void onClickDeleteButton() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.popup_message_confirmation_delete_account)
                .setPositiveButton(R.string.popup_message_choice_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteUserFromFirebase();
                    }
                })
                .setNegativeButton(R.string.popup_message_choice_no, null)
                .show();
    }


    private void updateUIWhenCreating(){

        if (this.getCurrentUser() != null){

            //Get picture URL from Firebase
            if (this.getCurrentUser().getPhotoUrl() != null) {
                Glide.with(this)
                        .load(this.getCurrentUser().getPhotoUrl())
                        .apply(RequestOptions.circleCropTransform())
                        .into(imageViewProfile);
            }

            //Get email & username from Firebase
            String email = TextUtils.isEmpty(this.getCurrentUser().getEmail()) ? getString(R.string.info_no_email_found) : this.getCurrentUser().getEmail();
            String username = TextUtils.isEmpty(this.getCurrentUser().getDisplayName()) ? getString(R.string.info_no_username_found) : this.getCurrentUser().getDisplayName();

            //Update views with data
            this.textInputEditTextUsername.setHint(username);
            this.textViewEmail.setText(email);
        }}

    public void signOutUserFromFirebase(){

        AuthUI.getInstance()
                .signOut(this)
                .addOnSuccessListener(this, this.updateUIAfterRESTRequestsCompleted(SIGN_OUT_TASK));
    }

    public void deleteUserFromFirebase(){

        if (this.getCurrentUser() != null) {
           AuthUI.getInstance()
                    .delete(this)
                    .addOnSuccessListener(this, this.updateUIAfterRESTRequestsCompleted(DELETE_USER_TASK));
        }
   }
    public OnSuccessListener<Void> updateUIAfterRESTRequestsCompleted(final int origin){
        return new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                switch (origin){
                    case SIGN_OUT_TASK:
                        finish();
                        break;
                    case DELETE_USER_TASK:
                        finish();
                        break;
                    default:
                        break;
                }
            }
        };

}

    @Nullable
    protected FirebaseUser getCurrentUser(){ return FirebaseAuth.getInstance().getCurrentUser(); }

    protected Boolean isCurrentUserLogged(){ return (this.getCurrentUser() != null); }
}
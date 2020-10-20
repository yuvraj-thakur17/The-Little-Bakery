package com.example.littlebakery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.example.littlebakery.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Slash_Activity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash_);

        firebaseAuth = FirebaseAuth.getInstance();

        SystemClock.sleep(3000);

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser == null){
            Intent registerIntent = new Intent(Slash_Activity.this,Register_Activity.class);
            startActivity(registerIntent);
            finish();
        }else {
            Intent mainIntent = new Intent(Slash_Activity.this,MainActivity.class);
            startActivity(mainIntent);
            finish();
        }
    }
}
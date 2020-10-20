package com.example.littlebakery;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.littlebakery.SignInFragment;
import com.example.littlebakery.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpFragment extends Fragment {

    public SignUpFragment() {
        // Required empty public constructor
    }

    private TextView alredyhaveanaccount;
    private FrameLayout parentFramelayout;

    private EditText email;
    private EditText fullname;
    private EditText password;
    private EditText confirmpassword;

    private ImageView closebutton;
    private Button signUpbutton;

    private ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;

    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        parentFramelayout = getActivity().findViewById(R.id.register_framelayout);

        alredyhaveanaccount = view.findViewById(R.id.alreadyhaveaccount_signup);

        email = view.findViewById(R.id.enteremail_signup);
        fullname = view.findViewById(R.id.entername_signup);
        password = view.findViewById(R.id.enterpassword_signup);
        confirmpassword = view.findViewById(R.id.confirmpassword_signup);
        closebutton= view.findViewById(R.id.cross_signin);
        signUpbutton = view.findViewById(R.id.signup_button_signup);
        progressBar = view.findViewById(R.id.progressBar_signup);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alredyhaveanaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignInFragment());
            }
        });

        closebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainIntent();
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        fullname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        confirmpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        signUpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkEmailAndPassword();
            }
        });

    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);
        fragmentTransaction.replace(parentFramelayout.getId() ,fragment);
        fragmentTransaction.commit();
    }
    private void checkInputs(){
        if (!TextUtils.isEmpty(email.getText())){
            if (!TextUtils.isEmpty(fullname.getText())){
                if (!TextUtils.isEmpty(password.getText()) && password.length() >=8){
                    if (!TextUtils.isEmpty(confirmpassword.getText())){
                        signUpbutton.setEnabled(true);
                        signUpbutton.setTextColor(Color.rgb(255,255,255));
                    }else {
                        signUpbutton.setEnabled(false);
                        signUpbutton.setTextColor(Color.rgb(255,255,255));
                    }
                }else {
                    signUpbutton.setEnabled(false);
                    signUpbutton.setTextColor(Color.rgb(255,255,255));
                }
            }else{
                signUpbutton.setEnabled(false);
                signUpbutton.setTextColor(Color.rgb(255,255,255));
            }
        }else {
            signUpbutton.setEnabled(false);
            signUpbutton.setTextColor(Color.rgb(255,255,255));
        }
    }
    private  void checkEmailAndPassword(){

        Drawable customErrorIcon = getResources().getDrawable(R.drawable.custom_error_icon);
        customErrorIcon.setBounds(0,0,customErrorIcon.getIntrinsicWidth(),customErrorIcon.getIntrinsicHeight());
        if (email.getText().toString().matches(emailPattern)){
            if (password.getText().toString().equals(confirmpassword.getText().toString())){

                progressBar.setVisibility(View.VISIBLE);

                signUpbutton.setEnabled(false);
                signUpbutton.setTextColor(Color.rgb(255,255,255));

                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isComplete()){

                                    Map<Object,String > userdata = new HashMap<>();
                                    userdata.put("fullname",fullname.getText().toString());

                                    firebaseFirestore.collection("USERS")
                                            .add(userdata)
                                            .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                                @Override
                                                public void onComplete(@NonNull Task<DocumentReference> task) {
                                                    if (task.isSuccessful()){
                                                        MainIntent();
                                                    }else {
                                                        progressBar.setVisibility(View.INVISIBLE);
                                                        signUpbutton.setEnabled(true);
                                                        signUpbutton.setTextColor(Color.rgb(255,255,255));
                                                        String error = task.getException().getMessage();
                                                        Toast.makeText(getActivity(),error, Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });

                                }else {
                                    signUpbutton.setEnabled(true);
                                    signUpbutton.setTextColor(Color.rgb(255,255,255));
                                    String error = task.getException().getMessage();
                                    Toast.makeText(getActivity(),error, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }else {
                confirmpassword.setError("Password doesn't matched!",customErrorIcon);
            }
        }else {
            email.setError("Invalid Email!",customErrorIcon);
        }
    }

    private void MainIntent(){
        Intent mainIntent = new Intent(getActivity(),MainActivity.class);
        startActivity(mainIntent);
        getActivity().finish();
    }
}
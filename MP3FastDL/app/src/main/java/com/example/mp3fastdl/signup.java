package com.example.mp3fastdl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText fullName;
    EditText email;
    EditText country;
    EditText phoneNumber;
    EditText password;
    TextView newprofile;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullName = findViewById(R.id.editText3);
        email = findViewById(R.id.editText5);
        country = findViewById(R.id.editText8);
        phoneNumber = findViewById(R.id.editText7);
        password = findViewById(R.id.editText6);
        newprofile = findViewById(R.id.textView8);

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();



        newprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();
                String Fullname = fullName.getText().toString();
                String Phone = phoneNumber.getText().toString();

                if (TextUtils.isEmpty(Email)) {
                    email.setError("Email is required!");
                    return;
                }
                if (TextUtils.isEmpty(Password)) {
                    password.setError("Password is required!");
                    return;
                }
                if (Password.length() < 6) {
                    password.setError("Password must have more than 6 characters!");
                    return;
                }
                if (TextUtils.isEmpty(Fullname)){
                    fullName.setError("Fullname is required!");
                }
                if (TextUtils.isEmpty(Phone)){
                    phoneNumber.setError("Phone number is required!");
                }

                fAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(signup.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Login_page.class));
                        } else {
                            Toast.makeText(signup.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
                });
            }

    }

package com.example.saurav.donateblood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class logIn extends Activity {
   TextView signuplink;
   EditText email,pwd;
   Button login;

   private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        signuplink=findViewById(R.id.link_signup);

        email=findViewById(R.id.input_email);
        pwd=findViewById(R.id.input_password);

        mAuth =FirebaseAuth.getInstance();

        login =findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailtxt = email.getText().toString().trim();
                String pwdtext = pwd.getText().toString().trim();

                mAuth.signInWithEmailAndPassword(emailtxt , pwdtext).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            // checkUser();

                            startActivity(new Intent(getApplicationContext(),homePage.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

                        }
                        else{

                            Toast.makeText(getApplicationContext(), task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }

                    }

                    private void checkUser() {

                    }
                });


            }
        });


        signuplink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),signUp.class));
            }
        });
    }
}

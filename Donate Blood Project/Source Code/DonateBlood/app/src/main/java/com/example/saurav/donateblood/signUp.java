package com.example.saurav.donateblood;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signUp extends AppCompatActivity {
    TextView linklogin;
    Button signUpbTn;
    RadioGroup radioGroup;
    public String sbloodGroup,sfb,semail,spass,sname,sage,slastTime,stotaltime,snumber,sinterested;



    FirebaseAuth mAuth;

    EditText Sname, Spass,Sage,Semail,SlastTime,StotalTime,Sinterested,Snumber,Sfb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        linklogin=findViewById(R.id.link_login);

        signUpbTn=findViewById(R.id.btn_signup);
        radioGroup=findViewById(R.id.blood_group);

        mAuth=FirebaseAuth.getInstance();




        Sname=findViewById(R.id.id_name);
        Spass=findViewById(R.id.id_pwd);
        Sage=findViewById(R.id.id_age);
        Semail=findViewById(R.id.id_email);
        SlastTime=findViewById(R.id.id_lastdonateDate);
        StotalTime=findViewById(R.id.id_iffirstdonate);
        Sinterested=findViewById(R.id.id_interested);
        Snumber=findViewById(R.id.id_contactNumber);
        Sfb=findViewById(R.id.id_facebook);



        linklogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),logIn.class));
            }
        });

        signUpbTn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                startSigningUp();


            }

            private void startSigningUp() {

                //make all edit text to String
                  sname =Sname.getText().toString().trim();
                 spass =Spass.getText().toString().trim();
                  sage =Sage.getText().toString().trim();
                  semail =Semail.getText().toString().trim();
                  slastTime =SlastTime.getText().toString().trim();
                  stotaltime =StotalTime.getText().toString().trim();
                  sinterested =Sinterested.getText().toString().trim();
                  snumber =Snumber.getText().toString().trim();
                 sfb =Sfb.getText().toString().trim();

                //getting sbloodgroup from radiogroup

                checkRadioButton();

                 //Toast.makeText(getApplicationContext(),sbloodGroup,Toast.LENGTH_SHORT).show();

                 if(!TextUtils.isEmpty(sname) && !TextUtils.isEmpty(semail) &&!TextUtils.isEmpty(spass) &&!TextUtils.isEmpty(sbloodGroup) ) {


                     mAuth.createUserWithEmailAndPassword(semail, spass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {

                             if (task.isSuccessful()) {
                                 Toast.makeText(getApplicationContext(), "succesfull", Toast.LENGTH_SHORT).show();
                                 String user_id = mAuth.getCurrentUser().getUid().toString().trim();
                               /*  DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("users").child(user_id);
                                 db.child("name").setValue(sname);
                                 db.child("age").setValue(sage);
                                 db.child("bloodGroup").setValue(sbloodGroup);
                                 db.child("interested").setValue(sinterested);
                                 db.child("lastDonate").setValue(slastTime);
                                 db.child("totaldonate").setValue(stotaltime);
                                 db.child("number").setValue(snumber);
                                 db.child("fb").setValue(sfb);
                                 db.child("email").setValue(semail);
                                 db.child("pass").setValue(spass);

                                 */

                                 DatabaseReference db=FirebaseDatabase.getInstance().getReference().child("users");
                                 DataBase cDatatbase=new DataBase(sname,semail,spass,sbloodGroup,sage,sfb,snumber,slastTime,stotaltime,sinterested);
                                 db.child(user_id).setValue(cDatatbase);
                                 DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("BloodGroup").child(sbloodGroup);
                                 databaseReference.child(user_id).setValue(cDatatbase);
                                 databaseReference.child(user_id).child("userId").setValue(user_id);

                                 startActivity(new Intent(getApplicationContext(), homePage.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

                             }
                             else{

                                 Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                             }
                         }


                     });

                 }

            }

            private void checkRadioButton() {
                int id=radioGroup.getCheckedRadioButtonId();
                if(id==R.id.A_positive){
                    sbloodGroup ="A+";
                }

                else if(id==R.id.A_negative){
                    sbloodGroup ="A-";
                }
                else if(id==R.id.B_positive){
                    sbloodGroup ="B+";
                }
                else if(id==R.id.B_negative){
                    sbloodGroup ="B-";
                }
                else if(id==R.id.AB_positive){
                    sbloodGroup ="AB+";
                }
                else if(id==R.id.AB_negative){
                    sbloodGroup ="AB-";
                }
                else if(id==R.id.O_positive){
                    sbloodGroup ="O+";
                }
                else if(id==R.id.O_negative){
                    sbloodGroup ="O-";
                }
                else{
                    sbloodGroup="nothing";
                }

            }
        });

    }
}

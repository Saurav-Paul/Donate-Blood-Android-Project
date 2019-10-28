package com.example.saurav.donateblood;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class createPostBlog extends AppCompatActivity {
    EditText postTitle,postdetails;
    Button discard,postit;
    DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;
    private DatabaseReference mUserDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post_blog);
        postTitle=findViewById(R.id.title_id);
        postdetails=findViewById(R.id.post_id);
        discard=findViewById(R.id.cancel_button);
        postit=findViewById(R.id.post_button);
        databaseReference=FirebaseDatabase.getInstance().getReference().child("Blog");


        mAuth=FirebaseAuth.getInstance();
        mCurrentUser=mAuth.getCurrentUser();

        mUserDatabase=FirebaseDatabase.getInstance().getReference().child("users").child(mCurrentUser.getUid());

        discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Discarding",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),homePage.class));
            }
        });

        postit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Title=postTitle.getText().toString().trim();
                String Detailspost=postdetails.getText().toString().trim();
                if(!TextUtils.isEmpty(Title) & !TextUtils.isEmpty(Detailspost)){
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat time=new SimpleDateFormat("HH:mm:ss");
                    SimpleDateFormat date =new SimpleDateFormat("dd-MM-yyyy");
                    String currentTime= time.format(calendar.getTime());
                    String currentDate= date.format(calendar.getTime());

                    final DatabaseReference newPost= databaseReference.push();
                    newPost.child("time").setValue(currentTime);
                    newPost.child("date").setValue(currentDate);
                    newPost.child("title").setValue(Title);
                    newPost.child("post").setValue(Detailspost);
                    newPost.child("uid").setValue(mCurrentUser.getUid());

                    mUserDatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                            newPost.child("username").setValue(dataSnapshot.child("userName").getValue());
                            Toast.makeText(getApplicationContext(),"Posting",Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(),homePage.class));

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(getApplicationContext(),"Error Happens",Toast.LENGTH_SHORT).show();

                        }
                    });



                }

            }
        });
    }
}
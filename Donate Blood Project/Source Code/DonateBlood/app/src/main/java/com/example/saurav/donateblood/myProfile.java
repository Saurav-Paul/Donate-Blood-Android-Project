package com.example.saurav.donateblood;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class myProfile extends Fragment {

    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;
    private DatabaseReference mUserDatabase;
    View v;

    TextView pName,pAge,pBldgrp,pinterest,plastTime,pemail,ptotal,pcontact,pfb;

    public myProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myFragmentView = inflater.inflate(R.layout.fragment_my_profile, container, false);

        mAuth=FirebaseAuth.getInstance();
        mCurrentUser=mAuth.getCurrentUser();

        pName=myFragmentView.findViewById(R.id.profile_name);
        pAge=myFragmentView.findViewById(R.id.profile_age);
        pBldgrp=myFragmentView.findViewById(R.id.profile_bloodgrp);
        pinterest=myFragmentView.findViewById(R.id.profile_interest);
        plastTime=myFragmentView.findViewById(R.id.profile_lasttime);
        pemail=myFragmentView.findViewById(R.id.profile_email);
        ptotal=myFragmentView.findViewById(R.id.profile_total);
        pcontact=myFragmentView.findViewById(R.id.profile_contact);
        pfb=myFragmentView.findViewById(R.id.profile_fb);




        mUserDatabase=FirebaseDatabase.getInstance().getReference().child("users").child(mCurrentUser.getUid());

                mUserDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        String name =dataSnapshot.child("userName").getValue().toString();
                        pName.setText("Name   : "+name);
                         pAge.setText("Age    : " + dataSnapshot.child("userAge").getValue().toString());
                         pBldgrp.setText("BloodGroup  : " + dataSnapshot.child("userBloodGroup").getValue().toString());
                        pinterest.setText("Interested in Donating : " + dataSnapshot.child("userInterest").getValue().toString());
                         plastTime.setText("Last Donation Date : " + dataSnapshot.child("userLastTimeDonation").getValue().toString());
                         pemail.setText("Email  : " + dataSnapshot.child("useremail").getValue().toString());
                         ptotal.setText("Location  : " + dataSnapshot.child("userTotalDonate").getValue().toString());
                        pcontact.setText("Contact Number : " + dataSnapshot.child("userNumber").getValue().toString());
                         pfb.setText("Facebook Profile  : " + dataSnapshot.child("userFb").getValue().toString());



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getContext(),"try3",Toast.LENGTH_SHORT).show();
                    }
                });





        // Inflate the layout for this fragment
        return myFragmentView;

       // return inflater.inflate(R.layout.fragment_my_profile, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}

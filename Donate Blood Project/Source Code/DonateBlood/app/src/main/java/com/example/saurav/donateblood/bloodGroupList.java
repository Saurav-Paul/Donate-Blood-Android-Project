package com.example.saurav.donateblood;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class bloodGroupList extends AppCompatActivity {

    Globals sharedData = Globals.getInstance();
    String bldGrp;
    ListView listView;
    DatabaseReference databaseReference;
    List<Donor> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_group_list);
        bldGrp=sharedData.getValue();
        //Toast.makeText(getApplicationContext(),bldGrp,Toast.LENGTH_SHORT).show();
        listView=findViewById(R.id.clistview);
        TextView textView=findViewById(R.id.idlistName);
        textView.setText("DonorList : "+bldGrp);
        list=new ArrayList<>();

        databaseReference=FirebaseDatabase.getInstance().getReference().child("BloodGroup").child(bldGrp);
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot donorsnapshot : dataSnapshot.getChildren()){
                    Donor donor=donorsnapshot.getValue(Donor.class);
                    list.add(donor);
                }

                DonorList adapter=new DonorList(bloodGroupList.this,list);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

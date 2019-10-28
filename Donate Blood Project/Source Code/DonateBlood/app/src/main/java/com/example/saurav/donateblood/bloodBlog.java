package com.example.saurav.donateblood;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class bloodBlog extends Fragment implements View.OnClickListener {


    FloatingActionButton createPost;
    View v;
    String bldGrp;
    ListView listView;
    DatabaseReference databaseReference;
    List<BlogPost> bloglist;
    public bloodBlog() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        v =inflater.inflate(R.layout.fragment_blood_blog, container, false);
        listView=v.findViewById(R.id.postItemList);

        bloglist=new ArrayList<>();

        databaseReference=FirebaseDatabase.getInstance().getReference().child("Blog");
        createPost=v.findViewById(R.id.create_post_button);
        createPost.setOnClickListener(this);



        // Inflate the layout for this fragment
        return v ;

    }


    @Override
  public void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bloglist.clear();
                for(DataSnapshot donorsnapshot : dataSnapshot.getChildren()){
                    BlogPost donor=donorsnapshot.getValue(BlogPost.class);
                    bloglist.add(donor);
                }

                PostList adapter=new PostList(getActivity(),bloglist);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



    @Override
    public void onClick(View v) {
        if(v==createPost){
            Animation animation =AnimationUtils.loadAnimation(getContext() ,R.anim.rotate);
            createPost.startAnimation(animation);
             startActivity(new Intent(getActivity(),createPostBlog.class));

        }
    }



}

package com.example.saurav.donateblood;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class homePage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

private FirebaseAuth sAuth;
private  FirebaseAuth.AuthStateListener sAuthStateListener;
TextView pname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        loadFragment(new search_doner());
        setTitle("Donate Blood");
        sAuth = FirebaseAuth.getInstance();
        sAuthStateListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null){

                    Intent intent =new Intent(getApplicationContext(),logIn.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
            }
        };


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.optionmenu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.logout){
            FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
            firebaseAuth.signOut();
        }

        if(item.getItemId()==R.id.credits){
            startActivity(new Intent(getApplicationContext(),credits.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sAuth.addAuthStateListener(sAuthStateListener);





    }

    private boolean loadFragment(Fragment fragment){
        if(fragment !=null){

         getSupportFragmentManager().beginTransaction()
                 .replace(R.id.fragment_container,fragment).commit();
            return true;
        }

        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment=null;
        switch (menuItem.getItemId()){
            case R.id.navigation_donor:
                fragment = new search_doner();
            break;

            case R.id.navigation_profile :
                fragment = new myProfile();
                break;

            case R.id.navigation_blog:
                fragment = new bloodBlog();
                break;

        }

        return loadFragment(fragment);
    }
}

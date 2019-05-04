package com.manpro.pawlinks;

import android.content.Intent;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.manpro.pawlinks.Fragments.AdoptionFragment;
import com.manpro.pawlinks.Fragments.HomeFragment;
//import com.manpro.pawlinks.Fragments.MapsFragment;
import com.manpro.pawlinks.Fragments.QnaFragment;
import com.manpro.pawlinks.Fragments.TipsntricksFragment;


public class MainActivity extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener
{

    private Toolbar mainToolbar;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mainToolbar= (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);

        getSupportActionBar().setTitle(" ");


        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeFragment());


    }


    private boolean loadFragment(Fragment fragment)
    {
        if(fragment!=null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.relativeLayout, fragment)
                    .commit();
            return true;
        }
        return false;
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        switch (item.getItemId())
        {
            case R.id.menu_home:
                fragment = new HomeFragment();
                break;
            case R.id.menu_qna:
                fragment = new QnaFragment();
                break;
            case R.id.menu_tipsntricks:
                fragment = new TipsntricksFragment();
                break;
            case R.id.menu_adoption:
                fragment = new AdoptionFragment();
                break;
//            case R.id.menu_maps:
//                fragment = new MapsFragment();
//                break;


        }
        return loadFragment(fragment);
    }



    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentUser == null)
        {
            sendToLogin();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_logout:
                logout();
                return true;
                default:
                    return false;
        }

    }

    private void logout() {
        mAuth.signOut();
        sendToLogin();
    }
    private void sendToLogin() {
        Intent loginIntent = new Intent (MainActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }
}

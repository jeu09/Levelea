package com.example.sebastian.experience22;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.Profile;


public class DisplayMain extends ActionBarActivity {
    ViewPager pager;
    PagerTabStrip tab_strp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_main);
        DisplayAdapter dpager = new DisplayAdapter(getSupportFragmentManager());
        pager=(ViewPager)findViewById((R.id.pager));
       Profile profile =Profile.getCurrentProfile();
        Intent intent = new Intent(DisplayMain.this, FirstTimeSignInActivity.class);
        if(profile!=null){
           startActivity(intent);
        }

        pager.setAdapter(dpager);
        tab_strp=(PagerTabStrip)findViewById(R.id.tab_strip);
        tab_strp.setTextColor(Color.WHITE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
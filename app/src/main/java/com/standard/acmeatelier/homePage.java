package com.standard.acmeatelier;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class homePage extends AppCompatActivity {

    // Define navbar buttons
    Button home;
    Button design;
    Button inspire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.group_4));
        setContentView(R.layout.activity_home_page);

        // Bottom Navbar start
        /*
        home = findViewById(R.id.nav_home);
        design = findViewById(R.id.nav_design);
        inspire = findViewById(R.id.nav_inspire);

        home.setOnClickListener(v -> startActivity(new Intent(this, homePage.class)));
        design.setOnClickListener(v -> startActivity(new Intent(this, kiltSelect.class)));
        inspire.setOnClickListener(v -> startActivity(new Intent(this, galleryPage.class)));
        */

        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.actionbarlogo, null);
        actionBar.setCustomView(view);
        // Bottom Navbar end
    }
}
package com.standard.acmeatelier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Button openLanding;
    Button moreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        openLanding = findViewById(R.id.button);
        moreButton = findViewById(R.id.button2);

        openLanding.setOnClickListener(v -> startActivity(new Intent(this, homePage.class)));
        moreButton.setOnClickListener(v -> startActivity(new Intent(this, morePage.class)));
    }
}
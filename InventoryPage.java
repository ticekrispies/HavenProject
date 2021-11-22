package com.standard.acmeatelier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class InventoryPage extends AppCompatActivity {

    Button backButton;
    Button addButton;
    Button editButton;
    Button deleteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_page);

        backButton = findViewById(R.id.button);

        backButton.setOnClickListener(view -> startActivity(new Intent(this, homePage.class)));
    }
}
package com.standard.havenjager;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.*;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        try {
            System.out.println("TRY");
            SentinoTest();
        } catch (IOException e) {
            System.out.println("FAILED");
            e.printStackTrace();
        }

        // Bottom Nav Bar start
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

            //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
        // Bottom Nav Bar end
    }

    public void SentinoTest() throws IOException {
        String data = "{'text': 'I am 30 years old man. I studied physics and currently work as a software engineer. I am married and have a couple of kids. What else I can tell... I am open to new experience and like to chat. I am being nasty sometimes.','inventories': ['big5', 'neo'],'lang': 'en'}";

        Uri uri = Uri.parse("https://sentino.org/api/v2/person/description");
        Uri.Builder uriBuilder = uri.buildUpon();
        uriBuilder.appendQueryParameter("Authorization", "Token c20ff2e4553c7260ff45438a8a9fef99983d0d42");
        uriBuilder.appendQueryParameter("Content-Type", "application/json");
        uriBuilder.appendQueryParameter("-d", data);

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        StringRequest request = new StringRequest(
                Request.Method.POST,
                uri.toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response);
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("FAIL");
                        System.out.println(error);
                        System.out.println(uriBuilder.toString());
                    }
                });
        queue.add(request);
    }



    // Method for bottom nav bar
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.navigation_design:
                            selectedFragment = new TestFragment();
                            break;
                        case R.id.navigation_inspire:
                            selectedFragment = new InfoFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}
package com.standard.acmeatelier;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;

import androidx.appcompat.app.AppCompatActivity;

public class galleryPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.group_4));
        setContentView(R.layout.activity_gallery_page);

        // Bottom Navbar start
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.actionbarlogo, null);
        actionBar.setCustomView(view);
        // Bottom Navbar end
    }

    public void hideImage(View view) {
        if (view.getAlpha() == 1) {
            AlphaAnimation hideImage = new AlphaAnimation(1f, 0f);
            hideImage.setDuration(1000);
            hideImage.setFillAfter(true);
            view.startAnimation(hideImage);
        } else {
            AlphaAnimation showImage = new AlphaAnimation(0f, 1f);
            showImage.setDuration(1000);
            showImage.setFillAfter(true);
            view.startAnimation(showImage);
        }
    }
}

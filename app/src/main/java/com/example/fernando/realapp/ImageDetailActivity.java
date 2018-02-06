package com.example.fernando.realapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageDetailActivity extends AppCompatActivity {

    public String imageDetailString;
    public ImageView imageViewDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        imageViewDetail = (ImageView) findViewById(R.id.imageview_image_detail);


        Intent intent = getIntent();

        if (intent != null) {
            imageDetailString = intent.getExtras().getString("image");

            int resID = getResources().getIdentifier(imageDetailString, "drawable", getPackageName());

            imageViewDetail.setImageResource(resID);

        }
    }
}

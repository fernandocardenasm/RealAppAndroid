package com.example.fernando.realapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class DigitalSelfActivity extends AppCompatActivity {

    public static Person personSelected;
    public static Person digitalSelfSelected;

    public String[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_self);

        if (personSelected != null && digitalSelfSelected != null) {

            images = new String[2];
            images[0] = digitalSelfSelected.imageSelf;
            images[1] = digitalSelfSelected.imageFriend;

            GridView gridView = (GridView)findViewById(R.id.gridviewDigital);
            DigitalSelfAdapter imagesAdapter = new DigitalSelfAdapter(this, images);
            gridView.setAdapter(imagesAdapter);

        }
    }
}

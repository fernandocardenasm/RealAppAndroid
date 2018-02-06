package com.example.fernando.realapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImageDetailActivity extends AppCompatActivity {

    public String imageDetailString;
    public ImageView imageViewDetail;

    public ArrayList<LogData> logs;

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

            if (intent.getExtras().getString("type").equals("imageStranger")){
                setTitle("Digital Self");
            }
            else {
                setTitle("Personal Updates");
            }

        }
    }

    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        if (intent != null) {

            logs = Helpers.loadLogs(getApplicationContext());

            if (logs == null) {
                logs = new ArrayList<LogData>();
            }

            logs.add(new LogData(Helpers.getCurrentDateTime(), ";UserSelected: " + intent.getStringExtra("user") +";OtherSelected: " + intent.getStringExtra("other") + ";Clicked on: " + intent.getStringExtra("type")));

            Helpers.saveLogs(getApplicationContext(), logs);
        }

    }
}

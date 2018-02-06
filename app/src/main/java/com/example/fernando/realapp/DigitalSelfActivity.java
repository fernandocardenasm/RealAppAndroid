package com.example.fernando.realapp;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class DigitalSelfActivity extends AppCompatActivity {

    public static Person personSelected;
    public static Person digitalSelfSelected;

    public String[] images;

    public ArrayList<LogData> logs;

    public ImageButton imageButtonStranger;
    public ImageButton imageButtonFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_self);

        imageButtonStranger = (ImageButton) findViewById(R.id.imageButtonStranger);
        imageButtonFriend = (ImageButton) findViewById(R.id.imageButtonFriend);


        if (personSelected != null && digitalSelfSelected != null) {

            if (isAFriend()){
                images = new String[2];
                images[0] = digitalSelfSelected.imageSelf;
                images[1] = digitalSelfSelected.imageFriend;
                int resIDF = getResources().getIdentifier(images[1], "drawable", getPackageName());

                imageButtonFriend.setImageResource(resIDF);

                imageButtonFriend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Intent intent = new Intent(DigitalSelfActivity.this.getApplicationContext(), ImageDetailActivity.class);

                        intent.putExtra("image", images[1]);
                        startActivity(intent);
                    }
                });
            }
            else {
                images = new String[1];
                images[0] = digitalSelfSelected.imageSelf;

                imageButtonFriend.setEnabled(false);
                imageButtonFriend.setVisibility(View.INVISIBLE);

            }

            int resIDS = getResources().getIdentifier(images[0], "drawable", getPackageName());

            imageButtonStranger.setImageResource(resIDS);

            imageButtonStranger.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent = new Intent(DigitalSelfActivity.this.getApplicationContext(), ImageDetailActivity.class);

                    intent.putExtra("image", images[0]);
                    startActivity(intent);
                }
            });


            /*GridView gridView = (GridView)findViewById(R.id.gridviewDigital);
            DigitalSelfAdapter imagesAdapter = new DigitalSelfAdapter(this, images);
            gridView.setAdapter(imagesAdapter);*/

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (personSelected != null && digitalSelfSelected != null) {

            logs = Helpers.loadLogs(getApplicationContext());

            if (logs == null) {
                logs = new ArrayList<LogData>();
            }

            logs.add(new LogData(Helpers.getCurrentDateTime(), ";UserSelected: " + personSelected.userName +";OtherSelected: " + digitalSelfSelected.userName));

            Helpers.saveLogs(getApplicationContext(), logs);
        }

    }

    public boolean isAFriend(){
        return personSelected.listFriends.contains(digitalSelfSelected.userId);
    }

}

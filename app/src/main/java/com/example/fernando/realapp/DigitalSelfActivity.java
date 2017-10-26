package com.example.fernando.realapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class DigitalSelfActivity extends AppCompatActivity {

    public static Person personSelected;
    public static Person digitalSelfSelected;

    public String[] images;

    public ArrayList<LogData> logs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_self);

        if (personSelected != null && digitalSelfSelected != null) {

            if (isAFriend()){
                images = new String[2];
                images[0] = digitalSelfSelected.imageFriend;
                images[1] = digitalSelfSelected.imageSelf;
            }
            else {
                images = new String[1];
                images[0] = digitalSelfSelected.imageSelf;
            }

            GridView gridView = (GridView)findViewById(R.id.gridviewDigital);
            DigitalSelfAdapter imagesAdapter = new DigitalSelfAdapter(this, images);
            gridView.setAdapter(imagesAdapter);

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

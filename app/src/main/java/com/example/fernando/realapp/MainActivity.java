package com.example.fernando.realapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Person[] people;

    public ArrayList<LogData> logs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        people = SeedData.seedData();

        GridView gridView = (GridView)findViewById(R.id.gridview);
        PeopleAdapter peopleAdapter = new PeopleAdapter(this, people);
        gridView.setAdapter(peopleAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person person = people[position];

                final Intent intent = new Intent(MainActivity.this.getApplicationContext(), ListActivity.class);

                ListActivity.userSelected = person;
                ListActivity.indexUserSelected = position;

                startActivity(intent);

            }
        });

    }

    final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
        public void onLongPress(MotionEvent e) {
            // The code for when a long-press happens
            if (logs != null){
                Log.v("Press", "It was pressed------------");
                Helpers.printLogs(getApplicationContext(), logs);
            }
        }
    });

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }


    @Override
    protected void onResume() {
        super.onResume();

        logs = Helpers.loadLogs(getApplicationContext());

        if (logs != null) {

        }
    }
}

package com.example.fernando.realapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Person[] people;

    public ArrayList<LogData> logs;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Who are you?");
        people = SeedData.seedData();

        GridView gridView = (GridView)findViewById(R.id.gridview);
        PeopleAdapter peopleAdapter = new PeopleAdapter(this, people);
        gridView.setAdapter(peopleAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Person person = people[position];
                final int personPos = position;

                // 1. Instantiate an AlertDialog.Builder with its constructor
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

// 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage("It is recommended that you select only yourself.")
                        .setTitle("Are you " + person.userName + "?");


                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        final Intent intent = new Intent(MainActivity.this.getApplicationContext(), ListActivity.class);

                        ListActivity.userSelected = person;
                        ListActivity.indexUserSelected = personPos;

                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

// 3. Get the AlertDialog from create()
                AlertDialog dialog = builder.create();

                dialog.show();

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

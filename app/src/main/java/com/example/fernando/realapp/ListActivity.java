package com.example.fernando.realapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    public Person[] peopleAux;
    public Person[] people;
    public static Person userSelected;
    public static int indexUserSelected;
    public ArrayList<LogData> logs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setTitle("I would like to see more from:");

        peopleAux = SeedData.seedData();


        if (userSelected != null) {

            int cont = 0;

            people = new Person[peopleAux.length];

            people = peopleAux;

            /*if (userSelected.listFriends.contains("")){
                people = new Person[peopleAux.length];

                people = peopleAux;
            }
            else{
                people = new Person[peopleAux.length - 1];

                for (int i = 0; i < peopleAux.length; i++) {

                    if (i != indexUserSelected) {
                        people[cont] = peopleAux[i];
                        cont++;
                    }
                }
            }*/


            GridView gridView = (GridView)findViewById(R.id.gridviewList);
            PeopleAdapter peopleAdapter = new PeopleAdapter(this, people);
            peopleAdapter.userSelected = userSelected;
            gridView.setAdapter(peopleAdapter);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Person person = people[position];

                    final Intent intent = new Intent(ListActivity.this.getApplicationContext(), DigitalSelfActivity.class);

                    DigitalSelfActivity.personSelected = userSelected;
                    DigitalSelfActivity.digitalSelfSelected = person;

                    startActivity(intent);

                }
            });



        }
    }

    final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
        public void onLongPress(MotionEvent e) {
            // The code for when a long-press happens
            if (logs != null){
                Log.v("Press", "It was pressed------------");

                //FireBase

                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                String idKey = database.getReference().push().getKey();
                DatabaseReference myRef = database.getReference(idKey);

                String str = "Android----Final User: " + userSelected.userName + " ";
                str = str + Helpers.getStringLogs(getApplicationContext(), logs);
                myRef.setValue(str);

                CharSequence text = "Your message was sent!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                toast.show();


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

        if (userSelected != null) {

            logs = Helpers.loadLogs(getApplicationContext());

            if (logs == null) {
                logs = new ArrayList<LogData>();
            }

            logs.add(new LogData(Helpers.getCurrentDateTime(), ";UserSelected: " + userSelected.userName));

            Helpers.saveLogs(getApplicationContext(), logs);
        }
    }

}

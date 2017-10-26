package com.example.fernando.realapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

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



        peopleAux = SeedData.seedData();
        people = new Person[peopleAux.length - 1];

        if (userSelected != null) {

            int cont = 0;

            for (int i = 0; i < peopleAux.length; i++) {

                if (i != indexUserSelected) {
                    people[cont] = peopleAux[i];
                    cont++;
                }
            }

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

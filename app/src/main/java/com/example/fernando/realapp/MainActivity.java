package com.example.fernando.realapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    public Person[] people;

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
}

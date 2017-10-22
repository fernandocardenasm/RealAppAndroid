package com.example.fernando.realapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class ListActivity extends AppCompatActivity {

    public Person[] peopleAux;
    public Person[] people;
    public static Person userSelected;
    public static int indexUserSelected;

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
            gridView.setAdapter(peopleAdapter);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
/*                    Person person = people[position];

                    final Intent intent = new Intent(MainActivity.this.getApplicationContext(), ListActivity.class);

                    ListActivity.userSelected = person;
                    ListActivity.indexUserSelected = position;

                    startActivity(intent);*/

                }
            });

        }

    }
}

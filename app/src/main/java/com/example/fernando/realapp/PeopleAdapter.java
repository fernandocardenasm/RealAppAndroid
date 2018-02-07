package com.example.fernando.realapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by fernando on 16.10.17.
 */

public class PeopleAdapter extends BaseAdapter {

    private final Context mContext;
    private final Person[] people;
    public Person userSelected;

    public PeopleAdapter(Context mContext, Person[] people) {
        this.mContext = mContext;
        this.people = people;
    }

    // 2
    @Override
    public int getCount() {
        return people.length;
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Person person = people[position];
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.linear_layout_person, null);

        }

        final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
        final TextView nameTextView = (TextView)convertView.findViewById(R.id.textview_book_name);
//        final TextView authorTextView = (TextView)convertView.findViewById(R.id.textview_book_author);
//        final ImageView imageViewFavorite = (ImageView)convertView.findViewById(R.id.imageview_favorite);

        int resID = mContext.getResources().getIdentifier(person.imageProfile, "drawable", mContext.getPackageName());
        imageView.setImageResource(resID);

        nameTextView.setText(person.userName);

        if (userSelected != null) {
            if (userSelected.listFriends.contains(person.userId)) {
                nameTextView.setBackgroundColor(Color.YELLOW);
            }

            if (userSelected.userId.equals(person.userId)) {
                nameTextView.setText("Show them yourself ;)");
                nameTextView.setBackgroundColor(Color.GREEN);
            }
            else {
                nameTextView.setText(person.userName);
            }
        }


//        authorTextView.setText(mContext.getString(book.getAuthor()));
//        imageViewFavorite.setImageResource(book.getIsFavorite() ? R.drawable.star_enabled : R.drawable.star_disabled);


        return convertView;
    }



}

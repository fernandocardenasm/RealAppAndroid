package com.example.fernando.realapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by fernando on 22.10.17.
 */

public class DigitalSelfAdapter extends BaseAdapter {

    private final Context mContext;
    private final String[] images;

    public DigitalSelfAdapter(Context mContext, String[] images) {
        this.mContext = mContext;
        this.images = images;
    }

    // 2
    @Override
    public int getCount() {
        return images.length;
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

        final String image = images[position];
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.digital_self_layout, null);
        }

        final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_cover_art_self);

        int resID = mContext.getResources().getIdentifier(image, "drawable", mContext.getPackageName());
        imageView.setImageResource(resID);

//        authorTextView.setText(mContext.getString(book.getAuthor()));
//        imageViewFavorite.setImageResource(book.getIsFavorite() ? R.drawable.star_enabled : R.drawable.star_disabled);


        return convertView;
    }



}
package com.mobile.rapidpay.rapidpaymobile;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oguzcan.emegil on 27.05.2017.
 */
public class CardAdapter extends ArrayAdapter<CardModel> {
    private Context context;
    private List<CardModel> rentalProperties;

    public CardAdapter(Context context, int resource, List<CardModel> objects) {
        super(context, resource, objects);

        this.context = context;
        this.rentalProperties = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        //get the property we are displaying
        CardModel property = rentalProperties.get(position);

        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.card_row_layout, null);

        TextView cardName = (TextView) view.findViewById(R.id.cardName);
        TextView cardNo = (TextView) view.findViewById(R.id.cardNo);


        //set address and description
        cardName.setText(property.getCardName());

        //display trimmed excerpt for description
        cardNo.setText(property.getCardNo());

        //set price and rental attributes
        return view;
    }
}

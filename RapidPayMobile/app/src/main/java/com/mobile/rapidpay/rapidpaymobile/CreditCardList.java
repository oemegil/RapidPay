package com.mobile.rapidpay.rapidpaymobile;

import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CreditCardList extends ListActivity {

    private TextView text;
    private List<CardModel> listValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card_list);

        listValues = new ArrayList<CardModel>();
        CardModel garantiCard=new CardModel(){};
        garantiCard.CardName="Garanti";
        garantiCard.CardNo="123-12-123-4";
        CardModel akbankCard=new CardModel(){};
        akbankCard.CardName="Akbank";
        akbankCard.CardNo="123-12-123-4";
        listValues.add(garantiCard);
        listValues.add(akbankCard);
        // initiate the listadapter
        ArrayAdapter<CardModel> myAdapter = new CardAdapter(this,0, listValues);
        // assign the list adapter
        setListAdapter(myAdapter);
        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.btnAddCard);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(CreditCardList.this, AddCardActivity.class));

            }
        });

    }

    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {

        super.onListItemClick(list, view, position, id);
        CardModel selectedItem = (CardModel) getListView().getItemAtPosition(position);
        LoadBalanceDialog dialog=new LoadBalanceDialog(CreditCardList.this);
        dialog.show();
    }

}

package com.mobile.rapidpay.rapidpaymobile;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class BillActivity extends AppCompatActivity{

    private Button btnPay;

    private ImageView mImageView;
    private EditText editTextAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        btnPay = (Button)findViewById(R.id.btnPay);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btnPay) {
                    Toast.makeText(BillActivity.this, "Paying Process is successfull.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BillActivity.this, MainActivity.class));
                }
            }
        });
        mImageView = (ImageView) findViewById(R.id.billImageView);
        mImageView.setImageResource(R.mipmap.billexample);

        editTextAmount = (EditText)findViewById(R.id.editTextAmount);
        /*editTextAmount.addTextChangedListener(new MoneyTextWatcher(editTextAmount));*/
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

}
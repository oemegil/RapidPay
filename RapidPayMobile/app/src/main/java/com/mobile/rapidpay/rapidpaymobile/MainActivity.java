package com.mobile.rapidpay.rapidpaymobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler  {
    private ZXingScannerView mScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.btnScanBarcode)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent myIntent = new Intent(MainActivity.this, BillActivity.class);
                startActivity(myIntent);*/

                //bkz:https://www.youtube.com/watch?v=JxwKfVh0K6I
                mScannerView = new ZXingScannerView(MainActivity.this);
                setContentView(mScannerView);
                mScannerView.setResultHandler(MainActivity.this);
                mScannerView.startCamera();
            }


        });
        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.btnCredit);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreditCardList.class));

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void handleResult(Result result) {
/*Log.w("handleResult", result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan result");
        builder.setMessage(result.getText());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();*/

        Intent billIntent = new Intent(MainActivity.this, BillActivity.class);
        startActivity(billIntent);

        //barcode okumaya devam etmesi icin
        //mScannerView.resumeCameraPreview(this);
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        if(mScannerView!=null){
            mScannerView.stopCamera();
        }
    }
}

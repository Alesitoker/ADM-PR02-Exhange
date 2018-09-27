package com.iessaladillo.alejandro.adm_pr02_exhange;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.iessaladillo.alejandro.adm_pr02_exhange.utils.ToastUtils;

public class MainActivity extends AppCompatActivity {

    private EditText txtAmount;
    private RadioGroup rdgFrom;
    private RadioGroup rdgTo;
    private ImageView imgTo;
    private ImageView imgFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        txtAmount = ActivityCompat.requireViewById(this, R.id.txtAmount);
        rdgFrom = ActivityCompat.requireViewById(this, R.id.rdgFrom);
        rdgTo = ActivityCompat.requireViewById(this, R.id.rdgTo);
        imgFrom = ActivityCompat.requireViewById(this, R.id.imgFrom);
        imgTo = ActivityCompat.requireViewById(this, R.id.imgTo);
        Button btnExchange = ActivityCompat.requireViewById(this, R.id.btnExchange);

        txtAmount.setOnClickListener(v -> ((EditText)v).selectAll());

        btnExchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currencyConverter();
            }
        });
    }

    private void currencyConverter() {
        int from = rdgFrom.getCheckedRadioButtonId(), to = rdgTo.getCheckedRadioButtonId(), resultado = 0;

        if (from == R.id.rdbFromDollar) {
            if (to == R.id.rdbToEuro) {

            } else if (to == R.id.rdbToPound) {

            }
        } else if (from == R.id.rdbFromEuro) {
            if (to == R.id.rdbToDollar) {

            } else if (to == R.id.rdbToPound) {

            }
        } else if (from == R.id.rdbFromPound) {
            if (to == R.id.rdbToEuro) {

            } else if (to == R.id.rdbToDollar) {

            }
        }
        ToastUtils.toast(this, );
    }
}

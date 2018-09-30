package com.iessaladillo.alejandro.adm_pr02_exhange;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.iessaladillo.alejandro.adm_pr02_exhange.utils.ToastUtils;

public class MainActivity extends AppCompatActivity {

    private EditText txtAmount;
    private RadioGroup rgFrom;
    private RadioButton rbFromDollar;
    private RadioButton rbFromEuro;
    private RadioButton rbFromPound;
    private RadioGroup rgTo;
    private RadioButton rbToDollar;
    private RadioButton rbToEuro;
    private RadioButton rbToPound;
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
        rgFrom = ActivityCompat.requireViewById(this, R.id.rgFrom);
        rbFromDollar = ActivityCompat.requireViewById(this, R.id.rbFromDollar);
        rbFromEuro = ActivityCompat.requireViewById(this, R.id.rbFromEuro);
        rbFromPound = ActivityCompat.requireViewById(this, R.id.rbFromPound);
        rgTo = ActivityCompat.requireViewById(this, R.id.rgTo);
        rbToDollar = ActivityCompat.requireViewById(this, R.id.rbToDollar);
        rbToEuro = ActivityCompat.requireViewById(this, R.id.rbToEuro);
        rbToPound = ActivityCompat.requireViewById(this, R.id.rbToPound);
        imgFrom = ActivityCompat.requireViewById(this, R.id.imgFrom);
        imgTo = ActivityCompat.requireViewById(this, R.id.imgTo);
        Button btnExchange = ActivityCompat.requireViewById(this, R.id.btnExchange);

        rgFrom.setOnCheckedChangeListener((group, checkedId) -> changeFrom(checkedId));
        rgTo.setOnCheckedChangeListener((group, checkedId) -> changeTo(checkedId));
        btnExchange.setOnClickListener(v -> currencyConverter());
    }

    private void changeTo(int checkedId) {
        if (checkedId == rbToDollar.getId()) {
            rbFromDollar.setEnabled(false);
            rbFromPound.setEnabled(true);
            rbFromEuro.setEnabled(true);
            imgTo.setImageResource(R.drawable.ic_dollar);
        }
        else if (checkedId == rbToEuro.getId()) {
            rbFromEuro.setEnabled(false);
            rbFromPound.setEnabled(true);
            rbFromDollar.setEnabled(true);
            imgTo.setImageResource(R.drawable.ic_euro);
        }
        else if (checkedId == rbToPound.getId()) {
            rbFromPound.setEnabled(false);
            rbFromDollar.setEnabled(true);
            rbFromEuro.setEnabled(true);
            imgTo.setImageResource(R.drawable.ic_pound);
        }
    }

    private void changeFrom(int checkedId) {
        if (checkedId == rbFromDollar.getId()) {
            rbToDollar.setEnabled(false);
            // Habilitamos los dos porque uno de ellos esta deshabilitado.
            rbToEuro.setEnabled(true);
            rbToPound.setEnabled(true);
            imgFrom.setImageResource(R.drawable.ic_dollar);
        }
        else if (checkedId == rbFromEuro.getId()) {
            rbToEuro.setEnabled(false);
            rbToDollar.setEnabled(true);
            rbToPound.setEnabled(true);
            imgFrom.setImageResource(R.drawable.ic_euro);
        }
        else if (checkedId == rbFromPound.getId()) {
            rbToPound.setEnabled(false);
            rbToEuro.setEnabled(true);
            rbToDollar.setEnabled(true);
            imgFrom.setImageResource(R.drawable.ic_pound);
        }
    }

    private void currencyConverter() {
        int from = rgFrom.getCheckedRadioButtonId(), to = rgTo.getCheckedRadioButtonId();
        char fromCurrency = ' ';
        char toCurrency;
        double resultado = 0, valor;
        final char DOLLAR = '$', EURO = '€', POUND = '£';
        final double DOLLAR_EURO = 0.861430, DOLLAR_POUND = 0.767491, EURO_DOLLAR = 1.16086, EURO_POUND = 0.890949, POUND_EURO = 1.12240, POUND_DOLLAR = 1.30297;
        try {
            valor  = Double.parseDouble(txtAmount.getText().toString());
        } catch (NumberFormatException e) {
            txtAmount.setText("0.00");
            return;
        }

        switch (from) {
            case R.id.rbFromDollar:
                fromCurrency = DOLLAR;
                if (to == R.id.rbToEuro) {
                    resultado = DOLLAR_EURO * valor;
                } else if (to == R.id.rbToPound) {
                    resultado = DOLLAR_POUND * valor;
                }
                break;
            case R.id.rbFromEuro:
                fromCurrency = EURO;
                if (to == R.id.rbToDollar) {
                    resultado = EURO_DOLLAR * valor;
                } else if (to == R.id.rbToPound) {
                    resultado = EURO_POUND * valor;
                }
                break;
            case R.id.rbFromPound:
                fromCurrency = POUND;
                if (to == R.id.rbToEuro) {
                    resultado = POUND_EURO * valor;
                } else if (to == R.id.rbToDollar) {
                    resultado = POUND_DOLLAR * valor;
                }
                break;
        }
        switch (to) {
            case R.id.rbToEuro:
                toCurrency = EURO;
                break;
            case R.id.rbToDollar:
                toCurrency = DOLLAR;
                break;
            default:
                toCurrency = POUND;
                break;
        }
        ToastUtils.toast(this, getString(R.string.main_activity_exchange_message, valor, resultado, fromCurrency, toCurrency));
}
}

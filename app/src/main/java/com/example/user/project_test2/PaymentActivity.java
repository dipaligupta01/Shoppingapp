package com.example.user.project_test2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup radioGroup;
    Button buttonPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Personal Store");

        radioGroup = findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(this);
        buttonPay = findViewById(R.id.button_pay);
        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, CongratsActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radio_button_debit:
                Toast.makeText(this, "Currently this option is not available", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_button_upi:
                Toast.makeText(this, "Currently this option is not available", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_button_netbanking:
                Toast.makeText(this, "Currently this option is not available", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_button_cod:
                Toast.makeText(this, "Can Continue to Pay", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}





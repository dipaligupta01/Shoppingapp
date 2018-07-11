package com.example.user.project_test2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CongratsActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Personal Store");

        buttonContinue=findViewById(R.id.button_continue);

        buttonContinue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(CongratsActivity.this,HomepageActivity.class);
        startActivity(intent);
    }
}

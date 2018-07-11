package com.example.user.project_test2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Personal Store");

        textView=findViewById(R.id.text_view);

        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);

    }
}

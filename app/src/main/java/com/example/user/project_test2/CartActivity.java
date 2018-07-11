package com.example.user.project_test2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView imageView;
    TextView textPModel,textPPrice;
    Button buttonConfirm,buttonContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Personal Store");

        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("PRODUCT");


        imageView=findViewById(R.id.image_view);
        textPModel=findViewById(R.id.text_view_model);
        textPPrice=findViewById(R.id.text_view_price);
        buttonConfirm=findViewById(R.id.button_confirm);
        buttonContinue=findViewById(R.id.button_continue);

        //textPModel.setText(product.getpModel());
        //textPPrice.setText(product.getpPrice());

        buttonConfirm.setOnClickListener(this);
        buttonContinue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_confirm:
                Intent intent=new Intent(CartActivity.this,PaymentActivity.class);
                startActivity(intent);
                break;
            case R.id.button_continue:
                Intent intent1=new Intent(CartActivity.this,HomepageActivity.class);
                startActivity(intent1);
                break;
        }
    }
}

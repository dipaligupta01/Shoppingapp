package com.example.user.project_test2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class
EnlargedProduct extends AppCompatActivity implements View.OnClickListener {
    Button buttonBuy, buttonAdd;
    TextView textViewPModel, textViewPDisplay, textViewPOs, textViewPRam, textViewPProcessor, textViewPCamera, textViewPPrice;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlarged_product);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Personal Store");

        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("PRODUCT");

        Toast.makeText(this, "" + product.getpModel(), Toast.LENGTH_SHORT).show();

        databaseReference = FirebaseDatabase.getInstance().getReference("cart");

        String id = databaseReference.push().getKey();
        databaseReference.child(id).setValue(product);

        textViewPModel = findViewById(R.id.text_view_model);
        textViewPRam = findViewById(R.id.text_view_ram);
        textViewPCamera = findViewById(R.id.text_view_camera);
        textViewPPrice = findViewById(R.id.text_view_price);
        textViewPProcessor = findViewById(R.id.text_view_processor);
        textViewPOs = findViewById(R.id.text_view_os);
        textViewPDisplay = findViewById(R.id.text_view_display);

        textViewPDisplay.setText(product.getpDisplay());
        textViewPModel.setText(product.getpModel());
        textViewPOs.setText(product.getpOs());
        textViewPProcessor.setText(product.getpProcessor());
        textViewPPrice.setText(product.getpPrice());
        textViewPCamera.setText(product.getpCamera());
        textViewPRam.setText(product.getpRam());


        buttonAdd = findViewById(R.id.button_addtocart);
        buttonBuy = findViewById(R.id.button_buynow);

        buttonBuy.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_buynow:
                startActivity(new Intent(EnlargedProduct.this, PaymentActivity.class));
                break;
            case R.id.button_addtocart:
                Intent intent1 = new Intent(EnlargedProduct.this, CartActivity.class);
                startActivity(intent1);

                break;
        }
    }
}



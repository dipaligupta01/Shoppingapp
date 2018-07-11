package com.example.user.project_test2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity implements View.OnClickListener{

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    AdapterCart adapterCart;

    ImageView imageView;
    TextView textPModel,textPPrice;
    Button buttonConfirm,buttonContinue;

    DatabaseReference databaseReference;
    ArrayList<Product> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Cart");

        recyclerView = findViewById(R.id.recycle_view);
        adapterCart = new AdapterCart(this, list);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapterCart);
        recyclerView.setLayoutManager(layoutManager);

        databaseReference = FirebaseDatabase.getInstance().getReference("cart");

        buttonConfirm=findViewById(R.id.button_confirm);
        buttonContinue=findViewById(R.id.button_continue);

        buttonConfirm.setOnClickListener(this);
        buttonContinue.setOnClickListener(this);

        fetchCartData();
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

    private void fetchCartData(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot cartData : dataSnapshot.getChildren()){
                    Product product= cartData.getValue(Product.class);
                    list.add(product);

                }
                adapterCart.setData(list);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

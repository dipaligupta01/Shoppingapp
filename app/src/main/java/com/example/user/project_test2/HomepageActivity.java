package com.example.user.project_test2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class HomepageActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Category> list = new ArrayList<>();
    AdapterCategory adapterCategory;

    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Personal Store");

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser == null) {
            startActivity(new Intent(HomepageActivity.this, LoginActivity.class));
        }

        generateData();

        recyclerView = findViewById(R.id.recycle_view);
        adapterCategory = new AdapterCategory(this, list);
        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setAdapter(adapterCategory);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.action_profile:
                startActivity(new Intent(HomepageActivity.this,ProfileActivity.class));
                break;
            case R.id.action_cart:
                Intent intent=new Intent(HomepageActivity.this,CartActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    private void generateData() {
        Category category;

        category = new Category();
        category.setCatImage(R.drawable.iphone);
        category.setCatId(1);
        list.add(category);

        category = new Category();
        category.setCatImage(R.drawable.samsung);
        category.setCatId(2);
        list.add(category);

        category = new Category();
        category.setCatImage(R.drawable.nokia);
        category.setCatId(3);
        list.add(category);

        category = new Category();
        category.setCatImage(R.drawable.xiaomi);
        category.setCatId(4);
        list.add(category);

        category = new Category();
        category.setCatImage(R.drawable.lenovo);
        category.setCatId(5);
        list.add(category);

        category = new Category();
        category.setCatImage(R.drawable.oppo);
        category.setCatId(6);
        list.add(category);
    }
}


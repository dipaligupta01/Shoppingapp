package com.example.user.project_test2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.Toast;

import java.util.ArrayList;

public class HomepageActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Category> list = new ArrayList<>();
    AdapterCategory adapterCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Personal Store");

        generateData();

        recyclerView = findViewById(R.id.recycle_view);
        adapterCategory = new AdapterCategory(this, list);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setAdapter(adapterCategory);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
//    public boolean onOptionsItemSelected(Menu item){
//        switch (item.getItem(item)){
//            case R.id.action_profile:
//                Toast.makeText(this, "Profile Selected", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.action_cart:
//                Intent intent=new Intent(HomepageActivity.this,CartActivity.class);
//                startActivity(intent);
//                break;
//        }
//    }

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
        category.setCatImage(R.drawable.oopo);
        category.setCatId(6);
        list.add(category);
    }
}


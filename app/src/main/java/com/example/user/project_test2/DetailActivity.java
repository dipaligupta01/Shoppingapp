package com.example.user.project_test2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Product> filterList = new ArrayList<>();
    AdapterProduct adapterProduct;

    int catId;
    String catName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        catId = intent.getIntExtra("CAT_ID", 1);
        catName = intent.getStringExtra("CAT_NAME");
        Toast.makeText(this, ""+catName, Toast.LENGTH_SHORT).show();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(catName);



        recyclerView = findViewById(R.id.recycle_view);
        adapterProduct = new AdapterProduct(this, filterList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapterProduct);
        recyclerView.setLayoutManager(layoutManager);

        filterData(catId);
    }

    public void filterData(int catId){
        ArrayList<Product> list = generateData();
        for(int i=0;i<list.size();i++){
            Product product = list.get(i);
            int id = product.getCatId();
            if(id==catId){
                filterList.add(product);
            }
        }
        adapterProduct.setData(filterList);
    }


    public ArrayList<Product> generateData() {
        ArrayList<Product> list = new ArrayList<Product>();
        Product product;

        product = new Product();
        product.setCatId(1);
        product.setpImage("download.jpg");
        product.setpModel("Lenovo K6 Note");
        product.setpPrice("Price  Rs.8,949/-");
        product.setpRam("RAM 4GB");
        product.setpDisplay("Display 5.5inch");
        product.setpCamera("Primary Camera 16MP");
        product.setpOs("OS Android 6.0 Marshmallow ");
        product.setpProcessor("Processor 2GHz Octa Core");
        list.add(product);

        product = new Product();
        product.setCatId(2);
        product.setpImage("download.jpg");
        product.setpModel("Lenovo K6 Power");
        product.setpPrice("Price  Rs.8,399/-");
        product.setpRam("RAM 3GB");
        product.setpDisplay("Display 5.0inch");
        product.setpCamera("Primary Camera 13MP");
        product.setpOs("OS Android 6.0 Marshmallow ");
        product.setpProcessor("Processor 1.4GHz Octa Core");
        list.add(product);

        product = new Product();
        product.setCatId(2);
        product.setpImage("download.jpg");
        product.setpModel("Lenovo Z2 Plus");
        product.setpPrice("Price  Rs.16,999/-");
        product.setpRam("RAM 3GB");
        product.setpDisplay("Display 5.0inch");
        product.setpCamera("Primary Camera 13MP");
        product.setpProcessor("Processor  1.5GHz Octa Core");
        list.add(product);

        product = new Product();
        product.setCatId(3);
        product.setpImage("download.jpg");
        product.setpModel("Samsung J7 Pro");
        product.setpPrice("Price  Rs.16,900/-");
        product.setpRam("RAM  3GB");
        product.setpDisplay("Display  5.5inch");
        product.setpCamera("Primary Camera  13MP");
        product.setpOs("OS  Android 7.0 Nougat");
        product.setpProcessor("Processor  1.6GHz Octa Core");
        list.add(product);

        product = new Product();
        product.setCatId(3);
        product.setpImage("download.jpg");
        product.setpModel("Samsung Galaxy On Nxt");
        product.setpPrice("Price  Rs.15,900/-");
        product.setpRam("RAM  3GB");
        product.setpDisplay("Display  5.5inch");
        product.setpCamera("Primary Camera  13MP");
        product.setpOs("OS  Android 6.0 Marshmallow");
        product.setpProcessor("Processor  1.6GHz Octa Core");
        list.add(product);


//        product = new Product();
//        product.setpModel("Samsung Galaxy On8 ");
//        product.setpPrice("Price  Rs.12,090/-");
//        product.setpRam("RAM  3GB");
//        product.setpDisplay("Display  5.5inch");
//        product.setpCamera("Primary Camera  13MP");
//        product.setpOs("OS  Android 7.0 Nougat");
//        product.setpProcessor("Processor  1.6GHz Octa Core");
//        list.add(product);
//
//
//        product = new Product();
//        product.setpModel("Samsung Galaxy J4 ");
//        product.setpPrice("Price  Rs.11,990/-");
//        product.setpRam("RAM  2GB");
//        product.setpDisplay("Display  5.5inch");
//        product.setpCamera("Primary Camera  13MP");
//        product.setpOs("OS-Android Oreo");
//        product.setpProcessor("Processor 1.4GHz QuadCore");
//        list.add(product);
//
//
//        product = new Product();
//        product.setpModel("Samsung Galaxy S8 plus");
//        product.setpPrice("Price  Rs.64,900/-");
//        product.setpRam("RAM  6GB");
//        product.setpDisplay("Display  6.2inch");
//        product.setpCamera("Primary Camera  12MP");
//        product.setpOs("OS  Android 7 Nougat");
//        product.setpProcessor("Processor  1.9GHz Octa Core");
//        list.add(product);
//
//
//        product = new Product();
//        product.setpModel("Samsung Galaxy Note 8");
//        product.setpPrice("Price  Rs.67,900/-");
//        product.setpRam("RAM  6GB");
//        product.setpDisplay("Display  6.3inch");
//        product.setpCamera("Primary Camera  13MP");
//        product.setpOs("OS  Android 7.1.1 Nougat");
//        product.setpProcessor("Processor  1.7GHz Octa Core");
//        list.add(product);
//
//
//        product = new Product();
//        product.setpModel("APPLE iPhone X");
//        product.setpPrice("Price  Rs.95,390/-");
//        product.setpRam("RAM 3GB");
//        product.setpDisplay("Display 5.8inch");
//        product.setpCamera("Primary Camera 12MP");
//        product.setpOs("OS iOS 11.1.1 ");
//        product.setpProcessor("Processor Apple A11 Bionic");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("APPLE iPhone 8 Plus");
//        product.setpPrice("Price  Rs.77,560/-");
//        product.setpRam("RAM 3GB");
//        product.setpDisplay("Display 5.5inch");
//        product.setpCamera("Primary Camera 12MP");
//        product.setpOs("OS iOS 11 ");
//        product.setpProcessor("Processor Apple A11 Bionic");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("APPLE iPhone 8");
//        product.setpPrice("Price  Rs.67,940/-");
//        product.setpRam("RAM 2GB");
//        product.setpDisplay("Display 4.7inch");
//        product.setpCamera("Primary Camera 12MP");
//        product.setpOs("OS iOS 11");
//        product.setpProcessor("Processor Apple A11 Bionic");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("APPLE iPhone 6S");
//        product.setpPrice("Price  Rs.34,999/-");
//        product.setpRam("RAM 2GB");
//        product.setpDisplay("Display 4.7inch");
//        product.setpCamera("Primary Camera 12MP");
//        product.setpOs("OS iOS 9 ");
//        product.setpProcessor("Processor Apple A9");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("APPLE iPhone 5S");
//        product.setpPrice("Price  Rs.16,799/-");
//        product.setpRam("RAM 1GB");
//        product.setpDisplay("Display 4.0inch");
//        product.setpCamera("Primary Camera 8MP");
//        product.setpOs("OS iOS 11.1.1 ");
//        product.setpProcessor("Processor Apple A7");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("APPLE iPhone 4S");
//        product.setpPrice("Price  Rs.9,950./-");
//        product.setpRam("RAM 512MB");
//        product.setpDisplay("Display 4.0inch");
//        product.setpCamera("Primary Camera 8MP");
//        product.setpOs("OS iOS 11.1.1 ");
//        product.setpProcessor("Processor Apple A5");
//        list.add(product);
//
//
//        product = new Product();
//        product.setpModel("OPPO Find X");
//        product.setpPrice("Price  Rs.59,990/-");
//        product.setpRam("RAM 8GB");
//        product.setpDisplay("Display 6.42inch");
//        product.setpCamera("Primary Camera 16MP");
//        product.setpOs("OS Android 8.1 Oreo ");
//        product.setpProcessor("Processor 2.82GHz Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("OPPO F7");
//        product.setpPrice("Price  Rs.19,539/-");
//        product.setpRam("RAM 4GB");
//        product.setpDisplay("Display 6.23inch");
//        product.setpCamera("Primary Camera 16MP");
//        product.setpOs("OS Android 8.1 Oreo ");
//        product.setpProcessor("Processor 2GHz Octa Core");
//        list.add(product);
//
//
//        product = new Product();
//        product.setpModel("OPPO A5");
//        product.setpPrice("Price  Rs.12,990/-");
//        product.setpRam("RAM 4GB");
//        product.setpDisplay("Display 6.2inch");
//        product.setpCamera("Primary Camera 13MP");
//        product.setpOs("OS Android 8.1 Oreo ");
//        product.setpProcessor("Processor 2.5GHz Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("OPPO A83");
//        product.setpPrice("Price  Rs.10,899/-");
//        product.setpRam("RAM 3GB");
//        product.setpDisplay("Display 5.7inch");
//        product.setpCamera("Primary Camera 13MP");
//        product.setpOs("OS Android 7.1 Oreo ");
//        product.setpProcessor("Processor 2.82GHz Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("OPPO Find X Lamborghni Edition");
//        product.setpPrice("Price  Rs.1,29,000/-");
//        product.setpRam("RAM 8GB");
//        product.setpDisplay("Display 6.42inch");
//        product.setpCamera("Primary Camera 16MP");
//        product.setpOs("OS Android 8.1 Oreo ");
//        product.setpProcessor("Processor 2.82GHz Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("NOKIA 8 Sirocco");
//        product.setpPrice("Price  Rs.49,999/-");
//        product.setpRam("RAM 6GB");
//        product.setpDisplay("Display 5.5inch");
//        product.setpCamera("Primary Camera 12MP");
//        product.setpOs("OS Android Oreo ");
//        product.setpProcessor("Processor 1.8GHz Octa Core");
//        list.add(product);
//
//
//        product = new Product();
//        product.setpModel("NOKIA 8");
//        product.setpPrice("Price  Rs.26,839/-");
//        product.setpRam("RAM 4GB");
//        product.setpDisplay("Display 5.3inch");
//        product.setpCamera("Primary Camera 13MP");
//        product.setpOs("OS Android Oreo ");
//        product.setpProcessor("Processor Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("NOKIA 7 Plus");
//        product.setpPrice("Price  Rs.25,999/-");
//        product.setpRam("RAM 4GB");
//        product.setpDisplay("Display 6inch");
//        product.setpCamera("Primary Camera 12MP");
//        product.setpOs("OS Android Oreo ");
//        product.setpProcessor("Processor  Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("NOKIA 6.1");
//        product.setpPrice("Price  Rs.16,999/-");
//        product.setpRam("RAM 4GB");
//        product.setpDisplay("Display 5.5inch");
//        product.setpCamera("Primary Camera 16MP");
//        product.setpOs("OS Android Oreo ");
//        product.setpProcessor("Processor Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("NOKIA 1");
//        product.setpPrice("Price  Rs.4,999/-");
//        product.setpRam("RAM 1GB");
//        product.setpDisplay("Display 4.5inch");
//        product.setpCamera("Primary Camera 5MP");
//        product.setpOs("OS Android 8.1 Oreo ");
//        product.setpProcessor("Processor 1.1GHz Quad Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("Xiomi Redmi Note5");
//        product.setpPrice("Price  Rs.11,999/-");
//        product.setpRam("RAM 4GB");
//        product.setpDisplay("Display 5.99inch");
//        product.setpCamera("Primary Camera 12MP");
//        product.setpOs("OS Android 7.1 Oreo ");
//        product.setpProcessor("Processor 2GHz Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("Xiomi Redmi Note5");
//        product.setpPrice("Price  Rs.11,999/-");
//        product.setpRam("RAM 4GB");
//        product.setpDisplay("Display 5.99inch");
//        product.setpCamera("Primary Camera 12MP");
//        product.setpOs("OS Android 7.1 Oreo ");
//        product.setpProcessor("Processor 2GHz Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("Xiomi Redmi Note5");
//        product.setpPrice("Price  Rs.11,999/-");
//        product.setpRam("RAM 4GB");
//        product.setpDisplay("Display 5.99inch");
//        product.setpCamera("Primary Camera 12MP");
//        product.setpOs("OS Android 7.1 Oreo ");
//        product.setpProcessor("Processor 2GHz Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("Xiomi Redmi Y2");
//        product.setpPrice("Price  Rs.9,999/-");
//        product.setpRam("RAM 3GB");
//        product.setpDisplay("Display 5.99inch");
//        product.setpCamera("Primary Camera 12MP");
//        product.setpOs("OS Android 8.1 Oreo ");
//        product.setpProcessor("Processor 2GHz Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("Xiomi Redmi Note 5 Pro");
//        product.setpPrice("Price  Rs.14,999/-");
//        product.setpRam("RAM 4GB");
//        product.setpDisplay("Display 5.99inch");
//        product.setpCamera("Primary Camera 12MP");
//        product.setpOs("OS Android 7.1.2 Oreo ");
//        product.setpProcessor("Processor 1.8GHz Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("Xiomi Mi A2");
//        product.setpPrice("Price  Rs.13,999/-");
//        product.setpRam("RAM 4GB");
//        product.setpDisplay("Display 5.99inch");
//        product.setpCamera("Primary Camera 12MP");
//        product.setpOs("OS Android 8.1 Oreo ");
//        product.setpProcessor("Processor 2.2GHz Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("Xiomi Redmi 5A");
//        product.setpPrice("Price  Rs.6,999/-");
//        product.setpRam("RAM 3GB");
//        product.setpDisplay("Display 5inch");
//        product.setpCamera("Primary Camera 13MP");
//        product.setpOs("OS Android 7.1.2 Oreo ");
//        product.setpProcessor("Processor 1.4GHz Quad Core");
//        list.add(product);
//
//
//        product = new Product();
//        product.setpModel("Lenovo P2");
//        product.setpPrice("Price  Rs.10,999/-");
//        product.setpRam("RAM 3GB");
//        product.setpDisplay("Display 5.5inch");
//        product.setpCamera("Primary Camera 13MP");
//        product.setpOs("OS Android 6.0 Marshmallow ");
//        product.setpProcessor("Processor 2GHz Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("Lenovo K8 PLUS");
//        product.setpPrice("Price  Rs.7,789/-");
//        product.setpRam("RAM 3GB");
//        product.setpDisplay("Display 5.2inch");
//        product.setpCamera("Primary Camera 13MP");
//        product.setpOs("OS Android 7.1.1 Nougat ");
//        product.setpProcessor("Processor 2.5GHz Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("Lenovo K8");
//        product.setpPrice("Price  Rs.8,980/-");
//        product.setpRam("RAM 2GB");
//        product.setpDisplay("Display 5.2inch");
//        product.setpCamera("Primary Camera 13MP");
//        product.setpOs("OS Android 7.1.1 Nougat  ");
//        product.setpProcessor("Processor 2GHz Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("Lenovo k8 Note");
//        product.setpPrice("Price  Rs.8,848/-");
//        product.setpRam("RAM 4GB");
//        product.setpDisplay("Display 5.5inch");
//        product.setpCamera("Primary Camera 13MP");
//        product.setpOs("OS Android 7.1.1 Nougat  ");
//        product.setpProcessor("Processor 2.3GHz Octa Core");
//        list.add(product);
//
//        product = new Product();
//        product.setpModel("Lenovo K6 NOTE");
//        product.setpPrice("Price  Rs.8,949/-");
//        product.setpRam("RAM 4GB");
//        product.setpDisplay("Display 5.5inch");
//        product.setpCamera("Primary Camera 16MP");
//        product.setpOs("OS Android 6.0 Marshmallow");
//        product.setpProcessor("Processor 1.4GHz Octa Core");
//        list.add(product);
        return list;

    }

}

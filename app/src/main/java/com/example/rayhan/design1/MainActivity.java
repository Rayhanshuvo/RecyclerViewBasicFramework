package com.example.rayhan.design1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//Format.............ctrl+alt+L
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDataBase database = AppDataBase.getAppDatabase(this);

        DataGenerator.with(database).generateAddress();
        database.addressDao().insert();
        Address[] address=database.addressDao().loadAll();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        for (int i = 0; i <address.length; i++) {

            ListItem listItem = new ListItem("City"+address[i].getCity(),"Street"+address[i].getStreet(),"Ok"+address[i].getPostCode());
           // ListItem listItem = new ListItem("City","Street");

            listItems.add(listItem);

        }

        adapter= new MyAdapter(listItems,this);
        recyclerView.setAdapter(adapter);


    }
}

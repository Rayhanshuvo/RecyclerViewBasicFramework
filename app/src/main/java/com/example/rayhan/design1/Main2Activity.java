package com.example.rayhan.design1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getIncomingIntent();
    }

    private void getIncomingIntent() {


        Log.d("TAG", "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("description") && getIntent().hasExtra("head") && getIntent().hasExtra("test")){
            Log.d("TAG1", "getIncomingIntent: found intent extras.");

            String description = getIntent().getStringExtra("description");
            Log.d("OK",description);
            String street = getIntent().getStringExtra("head");
            String test = getIntent().getStringExtra("test");

            setImage(description, street,test);
        }
    }

    private void setImage(String description, String street, String test) {

        TextView desc = findViewById(R.id.textView);
        TextView streetView = findViewById(R.id.textView2);
        TextView testView = findViewById(R.id.textView3);
        desc.setText(description);
        streetView.setText(street);
        testView.setText(test);
    }
}

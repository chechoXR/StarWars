package com.checho.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void people (View view){
        Intent intent = new Intent(this, people.class);
        startActivity(intent);



    }
    public void planet (View view){

        setContentView(R.layout.activity_planets);
    }


}

package com.example.jonny.photoapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.example.jonny.photoapp.R.id.enterB;
import static com.example.jonny.photoapp.R.id.exitB;
import static com.example.jonny.photoapp.R.id.viewB;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button enter = (Button) findViewById(enterB);
        enter.setOnClickListener(this);
        Button view = (Button) findViewById(viewB);
        view.setOnClickListener(this);
        Button exit = (Button) findViewById(exitB);
        exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch(v.getId()) {
            case enterB:
                Intent intent = new Intent(MainActivity.this, InformationActivity.class);
                startActivity(intent);
                break;
            case viewB:
                Intent infoInt = new Intent(MainActivity.this, ViewInfoActivity.class);
                startActivity(infoInt);
                break;
            case exitB:
                finish();
                System.exit(0);
        }
    }


}


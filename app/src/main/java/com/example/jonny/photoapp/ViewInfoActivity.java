package com.example.jonny.photoapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class ViewInfoActivity extends  AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_info);
        ListView text_V = (ListView) findViewById(R.id.Infor_View);
        try {
            Scanner file_Array = new Scanner(getFile());
            List<String> input = new ArrayList<String>();
            while(file_Array.hasNextLine()){
                input.add(file_Array.nextLine());
            }
            //create array to store file
            String [] Info_S = input.toArray(new String[0]);


            //Arrayadapter read file to the screen
            ArrayAdapter<String> show_Info = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1,Info_S);
            //assign adapter to listview
            text_V.setAdapter(show_Info);

        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    public String getFile() throws IOException {

       StringBuilder output = new StringBuilder();

        try {
            //open file for reading
            InputStream info = openFileInput("file.txt");

            if (info != null) {
                //prepare file for reading
                InputStreamReader input = new InputStreamReader(info);
                BufferedReader read = new BufferedReader(input);
                String line = "";
                while ((line = read.readLine()) != null) {
                    output.append(line);
                    output.append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

}

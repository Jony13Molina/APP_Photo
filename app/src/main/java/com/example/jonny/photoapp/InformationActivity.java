package com.example.jonny.photoapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Spinner spinner = (Spinner) findViewById(R.id.YearM);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Year, android.R.layout.simple_spinner_item);
        //specify layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //apply adapter to Spinner
        spinner.setAdapter(adapter);
    }
    public void Done(View view){
        try{
            //open file for writting
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput("file.txt", MODE_APPEND));
            //initializing writing photo name
            EditText t_Edit = (EditText)findViewById(R.id.Pname);
            String Np_input = t_Edit.getText().toString();
            //initializing writing phtogragher name
            EditText p_Edit  = (EditText)findViewById(R.id.Pgrapher);
            String Pn_Edit = p_Edit.getText().toString();
            //initializing writing year taken
            Spinner Year = (Spinner)findViewById(R.id.YearM);
            String  Y_edit = Year.getSelectedItem().toString();
            //writing to file photo name, photographer, and year taken
            out.write(Np_input);
            out.write(" ");
            out.write(Pn_Edit);
            out.write(" ");
            out.write(Y_edit);
            out.write('\n');

            //close file
            out.close();
            Toast.makeText(this,"Text Saved !",Toast.LENGTH_LONG).show();
        }
        catch(IOException e) {
            //do something if an IOException occurs.
            Toast.makeText(this, "Sorry Text could't be added", Toast.LENGTH_LONG).show();

        }

        finish();

    }

}



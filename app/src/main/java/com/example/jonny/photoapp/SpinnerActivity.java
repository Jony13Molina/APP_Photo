package com.example.jonny.photoapp;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;

/**
 * Created by jonny on 10/12/2017.
 */

public class SpinnerActivity extends InformationActivity implements AdapterView.OnItemSelectedListener{
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id){

        parent.getItemAtPosition(pos);
    }
    public void onNothingSelected(AdapterView<?> parent){
        System.out.println("Nothing Was Selected");
    }


}

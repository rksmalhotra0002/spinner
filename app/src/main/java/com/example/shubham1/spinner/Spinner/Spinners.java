package com.example.shubham1.spinner.Spinner;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shubham1.spinner.CustomSpinner.CustomSpinner;
import com.example.shubham1.spinner.R;

import java.util.ArrayList;

public class Spinners extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        getids();
    }

    private void getids() {


        Spinner spinner = findViewById(R.id.spinner);

        ArrayList<String> categories = new ArrayList<>();
        categories.add( "shubham");
        categories.add("karan");
        categories.add("arjun");
        categories.add("arsh");
        categories.add(0,"Select Category");

           ArrayAdapter<String>adapter= new ArrayAdapter<>(this,R.layout.color_spinner_layout, categories);
          adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position==0)
        {
           //no value
        }
       else if(position==1)
        {
           Intent intent=new Intent(Spinners.this, CustomSpinner.class);
           startActivity(intent);
        }

        else {
            String item = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), "" + item, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

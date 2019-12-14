package com.example.shubham1.spinner.CustomSpinner;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shubham1.spinner.R;
import com.example.shubham1.spinner.model.Model;

import java.util.ArrayList;

public class CustomSpinner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_spinner);
        getids();

    }

private void getids()
{
    Spinner custom_spinner = findViewById(R.id.custom_spinner);
    ArrayList<Model>a=new ArrayList<>();
    a.add(new Model("india",R.drawable.india));
    a.add(new Model("america",R.drawable.america));
    a.add(new Model("pakistan",R.drawable.pakistan));

    CustomAdapter adapter=new CustomAdapter(CustomSpinner.this,a);

    custom_spinner.setAdapter(adapter);
    custom_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if(position==0)
            {
                Toast.makeText(CustomSpinner.this,"india",Toast.LENGTH_LONG).show();
            }
            else if(position==1)
            {
                Toast.makeText(CustomSpinner.this,"america",Toast.LENGTH_LONG).show();
            }
            else if(position==2)
            {
                Toast.makeText(CustomSpinner.this,"pakistan",Toast.LENGTH_LONG).show();
            }


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });

}
 class CustomAdapter extends BaseAdapter
 {
  private Context context;
ArrayList<Model>arrayList;


     private CustomAdapter(Context context,ArrayList<Model>arrayList) {
         this.context = context;
         this.arrayList=arrayList;

     }

     @Override
     public int getCount() {
         return arrayList.size();
     }

     @Override
     public Object getItem(int position) {
         return null;
     }

     @Override
     public long getItemId(int position) {
         return 0;
     }


     @Override
     public View getView(int position, View convertView, ViewGroup parent) {
         Model model=arrayList.get(position);

         convertView = LayoutInflater.from(context).inflate(R.layout.demo,parent,false);
         TextView tv_text =  convertView.findViewById(R.id.tv_text);
         ImageView iv_image =  convertView.findViewById(R.id.iv_image);
         tv_text.setText(model.getName());
         iv_image.setImageResource(model.getImage());
         return convertView;
     }
 }
}
package com.example.calculatortheoryass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
private EditText edt1,edt2,edt3;
Button btn;
Spinner spn1;
TextView item;
private int value1=0;int value2=0;
private  int result;
ArrayList<String> listarray;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1=findViewById(R.id.spinner3);
        edt1=findViewById(R.id.editTextTextPersonName4);
        edt2=findViewById(R.id.editTextTextPersonName5);
        edt3=findViewById(R.id.editTextTextPersonName6);
        item=findViewById(R.id.item);
        btn=findViewById(R.id.button2);
        listarray=new ArrayList<>();
    listarray.add("add");
    listarray.add("subtract");
    listarray.add("multiply");
    listarray.add("divide");
    ArrayAdapter adapter =new ArrayAdapter(MainActivity.this,R.layout.item,R.id.item,listarray);
    spn1.setAdapter(adapter);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            value1=Integer.parseInt(edt1.getText().toString());
            value2=Integer.parseInt(edt2.getText().toString());
            if (spn1.getSelectedItem().toString()=="add") {
                result = value1 + value2;
                edt3.setText(String.valueOf(result));
            }
            else if (spn1.getSelectedItem().toString()=="multiply") {
                result = value1*value2;
                edt3.setText(String.valueOf(result));
            }
           else if (spn1.getSelectedItem().toString()=="subtract") {
                result = value1-value2;
                edt3.setText(String.valueOf(result));
            }
           else if (spn1.getSelectedItem().toString()=="divide") {
               if (value2==0)
                {

                    Toast.makeText(MainActivity.this,"dividing a num with zero",Toast.LENGTH_LONG).show();
                }
                else {
                    result=value1/value2;
                    edt3.setText("Qoutient: "+String.valueOf(result)+" Reminder:"+String.valueOf(value1/value2));
                }

            }
           else {
               Toast.makeText(MainActivity.this,"invalid",Toast.LENGTH_LONG).show();
            }

        }





    });




    }
}
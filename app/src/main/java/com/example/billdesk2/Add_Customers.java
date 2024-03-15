package com.example.billdesk2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Add_Customers extends AppCompatActivity {

    static String nm = "", ctt = "";
    String[] genderArray = {"Select Gender","Male", "Female", "Transgender"};
    String selectedGender = "";

    public void setdata(String name, String catg)
    {
        nm += name;
        ctt += catg;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customers);
        TextView mn = (TextView) findViewById(R.id.mern);
        TextView ct = (TextView) findViewById(R.id.cattxt);
        EditText name=(EditText) findViewById(R.id.CustName);
        EditText mob=(EditText) findViewById(R.id.CustMob) ;
        EditText addr=(EditText) findViewById(R.id.Address) ;

        mn.setText(mn.getText().toString() + ": " + nm);
        ct.setText(ct.getText().toString() + ": " + ctt);

        Spinner gender = findViewById(R.id.spinner);
        ArrayAdapter<String> durationAdapter = new ArrayAdapter<>(
                this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, genderArray
        );

        gender.setAdapter(durationAdapter);

        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedGender = genderArray[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button newcust=findViewById(R.id.newcustbtn);
        newcust.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                name.setText("");
                mob.setText("");
                addr.setText("");
             }
        });

        Button save=findViewById(R.id.SaveBtn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(name.getText().toString().equals("") || mob.getText().toString().equals("") || addr.getText().toString().equals(""))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Add_Customers.this);
                    builder.setMessage("Please Enter Customer name,mobile number and Address...!!");
                    builder.setTitle("Alert !");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else
                {
                    startActivity(new Intent(Add_Customers.this,AddProduct.class));
                }

            }
        });

    }
}



package com.example.billdesk2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=(Button) findViewById(R.id.start);


        TextView textView = findViewById(R.id.textView2);

        // Original text
        String fullText = textView.getText().toString();

        // Spannable string to apply color
        SpannableString spannableString = new SpannableString(fullText);

        // Index of the text you want to color
        int startIndex = fullText.indexOf("Calculate");
        int endIndex = startIndex + "Calculate".length();

        // Setting color to the specific text
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(52, 146, 235)), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Set the SpannableString to TextView
        textView.setText(spannableString);

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView mname=(TextView)  findViewById(R.id.mername);
                TextView catgory=(TextView) findViewById(R.id.cat);
                if(mname.getText().toString().equals("") && catgory.getText().toString().equals(""))
                {
                    // Create the object of AlertDialog Builder class
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    // Set the message show for the Alert time
                    builder.setMessage("Please Enter Valid Merchant name,Category");

                    // Set Alert Title
                    builder.setTitle("Alert !");

                    // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                    builder.setCancelable(false);
                    builder.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {
                    });

                    // Create the Alert dialog
                    AlertDialog alertDialog = builder.create();
                    // Show the Alert Dialog box
                    alertDialog.show();

                }
                else
                {
                    startActivity(new Intent(MainActivity.this, Add_Customers.class));
                }
                Add_Customers ac=new Add_Customers();
                ac.setdata(mname.getText().toString(),catgory.getText().toString());


            }
        });
    }
}
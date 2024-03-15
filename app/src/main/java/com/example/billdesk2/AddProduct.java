package com.example.billdesk2;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.billdesk2.BillModel;

import java.util.ArrayList;

public class AddProduct extends AppCompatActivity {
    ArrayList<BillModel> arrBill = new ArrayList<>();
    TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button addcart = findViewById(R.id.AddCartBtn);
        Button reset = findViewById(R.id.Reset);
        EditText pname = findViewById(R.id.ProName);
        EditText pquantity = findViewById(R.id.ProQnty);
        EditText pcat = findViewById(R.id.ProCat);
        EditText pprice = findViewById(R.id.ProPrice);
        totalTextView = findViewById(R.id.totalTextView); // Assuming you have a TextView with this id

        addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantityText = pquantity.getText().toString();
                String priceText = pprice.getText().toString();

                if (quantityText.isEmpty() || priceText.isEmpty()) {
                    // Check if quantity or price is empty
                    Toast.makeText(AddProduct.this, "Please enter quantity and price", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    int quantity = Integer.parseInt(quantityText);
                    int price = Integer.parseInt(priceText);
                    int totalPrice = quantity * price;

                    arrBill.add(new BillModel(pname.getText().toString(), quantityText, totalPrice));
                    Toast.makeText(AddProduct.this, "Product added to cart", Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    // Handle if quantity or price is not a valid number
                    Toast.makeText(AddProduct.this, "Invalid quantity or price", Toast.LENGTH_SHORT).show();
                }

                // Clear input fields
                pname.setText("");
                pquantity.setText("");
                pcat.setText("");
                pprice.setText("");

                // Update total
                totalTextView.setTextColor(Color.GREEN);
                updateTotal();
            }
        });

        RecyclerBillAdapter adapter1 = new RecyclerBillAdapter(this, arrBill);
        recyclerView.setAdapter(adapter1);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pname.setText("");
                pquantity.setText("");
                pcat.setText("");
                pprice.setText("");
            }
        });

        Button remove = findViewById(R.id.remove);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!arrBill.isEmpty()) {
                    arrBill.clear(); // Clear the ArrayList
                    adapter1.notifyDataSetChanged();
                    updateTotal();
                    Toast.makeText(AddProduct.this, "All products removed from cart", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddProduct.this, "Cart is already empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updateTotal() {
        int total = 0;
        for (BillModel model : arrBill) {
            total += model.getTotalPrice();
        }




        // Original text


        totalTextView.setText("Total payable amount: ₹" + total);
        String fullText = totalTextView.getText().toString();

        // Spannable string to apply color
        SpannableString spannableString = new SpannableString(fullText);

        // Index of the text you want to color
        int startIndex = fullText.indexOf("Total payable amount:");
        int endIndex = startIndex + "Total payable amount:".length();

        // Setting color to the specific text
        spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Set the SpannableString to TextView
        totalTextView.setText(spannableString);
    }
}

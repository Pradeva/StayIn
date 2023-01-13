package com.example.logregfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ReceiptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        Bundle extras = getIntent().getExtras();

        ImageButton buttonHome = findViewById(R.id.buttonback);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ReceiptActivity.this, HomeActivity.class);
                i.putExtras(extras);
                ReceiptActivity.this.startActivity(i);
                //startActivity(new Intent(ReceiptActivity.this, HomeActivity.class));
            }
        });



    }
}
package com.example.logregfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.logregfirebase.model.HistoryData;

public class DetailsActivity extends AppCompatActivity {
    Button btnBooking;
    HistoryData dataRiwayat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle extras = getIntent().getExtras();

        TextView nama = findViewById(R.id.textView2);
        nama.setText(extras.getString("namaData")+", "+extras.getString("namaDaerahData"));

        TextView harga = findViewById(R.id.textView3);
        harga.setText(extras.getString("hargaData"));

        ImageView gambar = (ImageView)findViewById(R.id.gambar1);
        gambar.setImageResource(extras.getInt("gambarData"));

        dataRiwayat = new HistoryData(extras.getString("namaData"),extras.getString("namaDaerahData"),extras.getString("hargaData"),extras.getInt("gambarData"));

        btnBooking = findViewById(R.id.booking);
        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailsActivity.this, PaymentActivity.class);
                i.putExtras(extras);
                DetailsActivity.this.startActivity(i);
                //startActivity(new Intent(DetailsActivity.this, PaymentActivity.class));
            }
        });
    }
}
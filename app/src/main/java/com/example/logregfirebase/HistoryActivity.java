package com.example.logregfirebase;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logregfirebase.adapter.HistoryAdapter;
import com.example.logregfirebase.model.HistoryData;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView historyRecycler;
    HistoryAdapter historyAdapter;
    DetailsActivity detail;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        Bundle extras = getIntent().getExtras();

        String nama = extras.getString("namaData");
        String namaDaerah = extras.getString("namaDaerahData");
        String harga = extras.getString("hargaData");
        Integer gambar = extras.getInt("gambarData");

        HistoryData dataRiwayat = detail.dataRiwayat;

        List<HistoryData> historyDataList = new ArrayList<>();

        historyDataList.add(new HistoryData(nama,namaDaerah,harga,gambar));

        //setHistoryRecycler(historyDataList);
    }

    private void setHistoryRecycler(List<HistoryData> historyDataList){
        historyRecycler = findViewById(R.id.history_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        historyRecycler.setLayoutManager((layoutManager));
        historyAdapter = new HistoryAdapter(this,historyDataList);
        historyRecycler.setAdapter(historyAdapter);
    }
}

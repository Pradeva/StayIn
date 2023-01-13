package com.example.logregfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.logregfirebase.adapter.RecentAdapter;
import com.example.logregfirebase.adapter.TopPlaceAdapter;
import com.example.logregfirebase.model.RecentData;
import com.example.logregfirebase.model.TopPlaceData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recentRecycler, topPlaceRecycler;
    RecentAdapter recentAdapter;
    TopPlaceAdapter topPlaceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle extras = getIntent().getExtras();

        //CRUD 1
        //CREATE
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> data = new HashMap<>();
        data.put("nama", "Hotel Ritz Carlton");
        data.put("namaDaerah", "Bandung");
        data.put("harga", "Rp 5,000,000");
        db.collection("hotel").add(data);
        // CREATE sampe sini


        try {
            boolean b = db().collection("hotel") != null;//FirebaseApp.getInstance() != null;
            Toast.makeText(HomeActivity.this, "database berhasil : " + b, Toast.LENGTH_LONG).show();
        } catch (IllegalStateException e) {
            Toast.makeText(HomeActivity.this, "database error", Toast.LENGTH_LONG).show();
        }

        FirebaseFirestore database = FirebaseFirestore.getInstance();

        //READ
        List<RecentData> recentDataList = new ArrayList<>();
        database.collection("hotel")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                recentDataList.add(new RecentData(document.getString("nama"), document.getString("namaDaerah"), document.getString("harga"), R.drawable.changie, R.drawable.changiee));
                            }
                        }
                    }
                });

        recentDataList.add(new RecentData("Hotel Markisa", "Malang", "Rp 399,000", R.drawable.markisa, R.drawable.markisabesar));
        recentDataList.add(new RecentData("Hotel Royale", "Jakarta", "Rp 550,000", R.drawable.royale, R.drawable.royalebesar));
        recentDataList.add(new RecentData("Hotel Harris", "Surabaya", "IDR 700,000", R.drawable.harris, R.drawable.harrisbesar));
        recentDataList.add(new RecentData("Hotel Amaroosa", "Bekasi", "IDR 900,000", R.drawable.amaroosa, R.drawable.amaroosabesar));
        recentDataList.add(new RecentData("Hotel Banana Inn", "Bandung", "IDR 1,000,000", R.drawable.bananainn, R.drawable.bananainnbesar));
        recentDataList.add(new RecentData("Hotel Melati", "Bandung", "IDR 1,299,000", R.drawable.melati, R.drawable.melatibesar));
        recentDataList.add(new RecentData("Hotel Ritz Carlton", "Bandung", "IDR 5,000,000", R.drawable.ritzcarlton, R.drawable.ritzcarltonbesar));

        setRecentRecycler(recentDataList);

        List<TopPlaceData> topPlaceDataList = new ArrayList<>();
        topPlaceDataList.add(new TopPlaceData("Hotel Ritz Carlton", "Bandung", "IDR 5,000,000", R.drawable.ritzcarlton, R.drawable.ritzcarltonbesar));
        topPlaceDataList.add(new TopPlaceData("Hotel Melati", "Bandung", "IDR 1,299,000", R.drawable.melati, R.drawable.melatibesar));
        topPlaceDataList.add(new TopPlaceData("Hotel Banana Inn", "Bandung", "IDR 1,000,000", R.drawable.bananainn, R.drawable.bananainnbesar));
        topPlaceDataList.add(new TopPlaceData("Hotel Amaroosa", "Bekasi", "IDR 900,000", R.drawable.amaroosa, R.drawable.amaroosabesar));
        topPlaceDataList.add(new TopPlaceData("Hotel Harris", "Surabaya", "IDR 700,000", R.drawable.harris, R.drawable.harrisbesar));
        topPlaceDataList.add(new TopPlaceData("Hotel Royale", "Jakarta", "Rp 550,000", R.drawable.royale, R.drawable.royalebesar));
        topPlaceDataList.add(new TopPlaceData("Hotel Markisa", "Malang", "Rp 399,000", R.drawable.markisa, R.drawable.markisabesar));

        setTopPlaceRecycler(topPlaceDataList);

        ImageView pemesanan = findViewById(R.id.historyPemesanan);
        pemesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,HistoryActivity.class);
                i.putExtras(extras);
                HomeActivity.this.startActivity(i);
                //startActivity(new Intent(HomeActivity.this,HistoryActivity.class));
            }
        });

    }
    private void setRecentRecycler(List<RecentData> recentDataList) {

        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recentRecycler.setLayoutManager((layoutManager));
        recentAdapter = new RecentAdapter(this, recentDataList);
        recentRecycler.setAdapter(recentAdapter);
    }

    private void setTopPlaceRecycler(List<TopPlaceData> topPlaceDataList) {

        topPlaceRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        topPlaceRecycler.setLayoutManager((layoutManager));
        topPlaceAdapter = new TopPlaceAdapter(this, topPlaceDataList);
        topPlaceRecycler.setAdapter(topPlaceAdapter);
    }
    static FirebaseFirestore db() {
        return FirebaseFirestore.getInstance();
    }

}
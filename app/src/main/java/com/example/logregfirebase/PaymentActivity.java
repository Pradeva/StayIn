package com.example.logregfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.logregfirebase.model.Kupon;
import com.example.logregfirebase.model.RecentData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;

    List<Kupon> ListKupon = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Bundle extras = getIntent().getExtras();

        radioGroup = findViewById(R.id.radioGroup);

        //CRUD 2

        //CREATE
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> data = new HashMap<>();
        data.put("kode", "DANAJCBS11 Royal Hotel");
        data.put("potongan", "20% off");
        db.collection("kupon").add(data);

        FirebaseFirestore database = FirebaseFirestore.getInstance();

        //READ
        database.collection("kupon")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                ListKupon.add(new Kupon(document.getString("kode"), document.getString("potongan")));
                            }
                        }
                    }
                });

        ListKupon.add(new Kupon("DANAJCBS11","20% off"));
        ListKupon.add(new Kupon("OVOJCBS11", "10% off"));

        Button buttonPay = findViewById(R.id.pay);
        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                Intent i = new Intent(PaymentActivity.this, ReceiptActivity.class);
                i.putExtras(extras);
                PaymentActivity.this.startActivity(i);
                //startActivity(new Intent(PaymentActivity.this, ReceiptActivity.class));
            }
        });
    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

    }
}
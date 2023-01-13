package com.example.logregfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextView reg;
    TextView home;
    EditText inputEmail, inputPassword;
    String email, password;
    Button btnLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.button);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekLogin();
                //startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }
        });

        reg = (TextView)findViewById(R.id.buatAkunBaru);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

    }

    private void cekLogin() { //private void
        email = inputEmail.getText().toString();
        password = inputPassword.getText().toString();

        if(email.isEmpty() && password.isEmpty()){
            Toast.makeText(MainActivity.this, "Masukkan Email dan Password", Toast.LENGTH_LONG).show();
        }else if(password.isEmpty()){
            Toast.makeText(MainActivity.this, "Masukkan Password", Toast.LENGTH_LONG).show();
        }else if(email.isEmpty()){
            Toast.makeText(MainActivity.this, "Masukkan Email", Toast.LENGTH_LONG).show();
        }

        if(!email.isEmpty() && !password.isEmpty()) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                                Toast.makeText(MainActivity.this, "Login Sukses.", Toast.LENGTH_LONG).show();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(MainActivity.this, "Login Gagal, Email atau Password anda salah.", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }
    }
}
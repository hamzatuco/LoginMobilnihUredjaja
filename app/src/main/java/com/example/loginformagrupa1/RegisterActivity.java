package com.example.loginformagrupa1;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {


    EditText username, email, password,passwordPotvrdi;
    Button btnRegister;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        vratiNaLogin();
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        passwordPotvrdi = findViewById(R.id.passwordPotvrdi);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriCredentials();
            }
        });
    }


    private void provjeriCredentials() {

        String mejl = email.getText().toString();
        String pass = password.getText().toString();
        String juzer = username.getText().toString();
        String passConf = passwordPotvrdi.getText().toString();

        if (juzer.isEmpty() || juzer.length()<5) {
            showError(username, "Korisnicko ime nije validno");
        }
        else if(mejl.isEmpty() || !mejl.contains("@")){
            showError(email, "E-mail nije validan");
        }
        else if (pass.isEmpty() || pass.length()<8){
            showError(password, "Sifra mora sadrzavati najmanje 8 karaktera");
        }
        else if (passConf.isEmpty() || !passConf.equals(pass)){
            showError(passwordPotvrdi, "Sifre se ne poklapaju");
        }

        else {
            Toast.makeText(this, "Registracija", Toast.LENGTH_SHORT).show();
        }
    }

    private void showError(EditText input, String s) {


        input.setError(s);
        input.requestFocus();


    }
    private void vratiNaLogin() {
        TextView login = (TextView) findViewById(R.id.vecPosjedujete);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }
}

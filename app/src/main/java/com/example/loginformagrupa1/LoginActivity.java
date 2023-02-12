package com.example.loginformagrupa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView btn;
    EditText email, sifra;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        vratiNaRegistar();

        email = findViewById(R.id.username);
        sifra = findViewById(R.id.sifra);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriCredentials();
            }
        });


    }


    private void provjeriCredentials() {

        String mejl = email.getText().toString();
        String pass = sifra.getText().toString();

        if (mejl.isEmpty() || !mejl.contains("@")) {
            showError(email, "Email nije validan");
        } else if (pass.isEmpty() || pass.length() < 8) {
            showError(sifra, "Sifra mora sadrzavati najmanje 8 karaktera");
        } else {
            Toast.makeText(this, "Registracija", Toast.LENGTH_SHORT).show();
        }
    }

    private void showError(EditText input, String s) {


        input.setError(s);
        input.requestFocus();


    }

    private void vratiNaRegistar() {
        TextView login = (TextView) findViewById(R.id.registar);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });


    }
}






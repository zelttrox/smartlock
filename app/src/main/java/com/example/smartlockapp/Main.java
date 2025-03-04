package com.example.smartlockapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;


public class Main extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.connexion);

    TextView token = findViewById(R.id.token);
    MaterialButton login = findViewById(R.id.login);

    String adminPassword = "47325" ;
    String[] userPassword = {"02158", "19756"} ;

login.setOnClickListener(v -> {

// int id = token.getText().toString().charAt(0) ;

if (token.getText().toString().equals(adminPassword) || token.getText().toString().equals(userPassword[0])) { // 0 = id

    Toast.makeText(Main.this, "Accès autorisé", Toast.LENGTH_SHORT).show() ;
    System.out.println("Login Successful");

    Intent connexion = new Intent(Main.this, Locker.class) ;
    startActivity(connexion) ;
}

else {

    Toast.makeText(Main.this, "Accès refusé (ID Incorrect)", Toast.LENGTH_SHORT).show() ;
    System.out.println("Login Failed") ; } } ) ;

} }

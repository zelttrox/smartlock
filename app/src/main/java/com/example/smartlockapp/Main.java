package com.example.smartlockapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;


public class Main extends AppCompatActivity {

    public String adminPassword = "47325" ; // admin
    public String[] userPassword = {"02158", "19756", "25821", "36347", "00000"} ; // profs

    Locker locker = new Locker() ;

    void createId(int x) {

    Locker.tokenId = x ;

}

    @Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.connexion);

    Locker locker = new Locker() ;

    String[] error = {"ID Incorrect"} ;

    TextView token = findViewById(R.id.token);
    MaterialButton login = findViewById(R.id.login);

login.setOnClickListener(v -> {

    if (token.getText().toString().equals(adminPassword)) {
        Toast.makeText(Main.this, "Accès autorisé", Toast.LENGTH_SHORT).show();
        System.out.println("Login Successful " + "(" + locker.user + ")");
        Intent connexion = new Intent(Main.this, Locker.class);
        createId(0) ;
        Main.this.startActivity(connexion); }

    else if (token.getText().toString().equals(userPassword[0])) {
        Toast.makeText(Main.this, "Accès autorisé", Toast.LENGTH_SHORT).show();
        System.out.println("Login Successful " + "(" + locker.user + ")");
        Intent connexion = new Intent(Main.this, Locker.class);
        createId(1) ;
        Main.this.startActivity(connexion); }

    else if (token.getText().toString().equals(userPassword[1])) {
        Toast.makeText(Main.this, "Accès autorisé", Toast.LENGTH_SHORT).show();
        System.out.println("Login Successful " + "(" + locker.user + ")");
        Intent connexion = new Intent(Main.this, Locker.class);
        Main.this.startActivity(connexion);
        createId(2) ; }

    else if (token.getText().toString().equals(userPassword[2])) {
        Toast.makeText(Main.this, "Accès autorisé", Toast.LENGTH_SHORT).show();
        System.out.println("Login Successful " + "(" + locker.user + ")");
        Intent connexion = new Intent(Main.this, Locker.class);
        createId(3) ;
        Main.this.startActivity(connexion); }

    else if (token.getText().toString().equals(userPassword[3])) {
        Toast.makeText(Main.this, "Accès autorisé", Toast.LENGTH_SHORT).show();
        System.out.println("Login Successful " + "(" + locker.user + ")");
        Intent connexion = new Intent(Main.this, Locker.class);
        createId(4) ;
        Main.this.startActivity(connexion); }

    else {

        Toast.makeText(Main.this, "Accès refusé " + "(" + error[0] + ")", Toast.LENGTH_SHORT).show();
        System.out.println("Login Failed") ; }

} ) ;

} }

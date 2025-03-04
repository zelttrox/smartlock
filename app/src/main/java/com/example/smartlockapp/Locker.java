package com.example.smartlockapp;

// Imports

import static com.example.smartlockapp.R.*;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.button.MaterialButton;

// Déclaration des variables
public class Locker extends AppCompatActivity {

    public String user = "";

    public static int tokenId;

    public boolean open = false;
    public boolean fan = false;

    // Fonction "Besoin d'aide ?"
    void needHelp() {
        Intent connexion = new Intent(Locker.this, NeedHelp.class);
        Locker.this.startActivity(connexion);
    }

    // Fonction onCreate

    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.smartlock);

        TextView needHelp = findViewById(id.needHelp);

        // Définition de l'utilisateur en fonction de l'ID entré

        switch (tokenId) {
            case 0:
                user = "ADMIN";
                break;
            case 1:
                user = "Pablo";
                break;
            case 2:
                user = "Eva";
                break;
            case 3:
                user = "Ribo C.";
                break;
            case 4:
                user = "Crousilles S.";
                break;
            case 5:
                user= "Caramajo R.";
        }

        // Définitions des IDs

        TextView username = findViewById(id.username);
        TextView state = findViewById(id.state);
        TextView vent = findViewById(id.vent);
        TextView bluetooth = findViewById(id.bluetooth);

        username.setText("Utilisateur: " + user);
        System.out.println("The user is " + user.toUpperCase());

        // Ventiliation

        if (fan == true) {
            vent.setText("Ventilateur: Activé");
        } else {
            vent.setText("Ventilateur: Désactivé");
        }

        // Bluetooth (à corriger)

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            System.out.println("Bluetooth indisponible");
            bluetooth.setText("Bluetooth: Indisponible");
            bluetooth.setBackgroundColor(Color.parseColor("#825753")) ; }
        else {
            if (!bluetoothAdapter.isEnabled()) {
                bluetooth.setText("Bluetooth: Indisponible");
                bluetooth.setBackgroundColor(Color.parseColor("#825753"));
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                bluetoothAdapter.enable() ; }
            else {
                bluetooth.setText("Bluetooth: Désactivé");
                bluetooth.setBackgroundColor(Color.parseColor("#825753"));

} } }

     // Fonction needHelp() (définie au dessus)

needHelp.setOnClickListener(v -> needHelp()) ;

     // Définition ID bouton

ImageButton unlock = findViewById(R.id.lockButton) ;

        // ColorDrawable à GradientDrawable

        GradientDrawable backgroundDrawable = new GradientDrawable();
        backgroundDrawable.setShape(GradientDrawable.OVAL);
        backgroundDrawable.setCornerRadius(200);
        backgroundDrawable.setStroke(2, Color.RED);
        backgroundDrawable.setColor(Color.parseColor("#2C2C2C"));
        unlock.setBackground(backgroundDrawable);

        // Bouton onClick

unlock.setOnClickListener(v -> {

    if (open == false) {
        open = true ;
        state.setBackgroundColor(Color.parseColor("#707d68"));
        GradientDrawable drawable = (GradientDrawable) unlock.getBackground();
        drawable.setStroke(2, Color.parseColor("#4cf436"));
        unlock.setBackgroundResource(R.drawable.baseline_lock_open_24);
        state.setText("Armoire: Ouverte") ; }

    else if (open == true) {
        open = false ;
        state.setBackgroundColor(Color.parseColor("#825753"));
        GradientDrawable drawable = (GradientDrawable) unlock.getBackground();
        drawable.setStroke(2, Color.parseColor("#F44336"));
        unlock.setBackgroundResource(R.drawable.baseline_lock_24);
        state.setText("Armoire: Fermée") ; }

} ) ;

} }

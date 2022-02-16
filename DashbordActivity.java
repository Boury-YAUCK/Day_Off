package com.example.day_off;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class DashbordActivity extends AppCompatActivity {

    private LinearLayout play, play1, play3,play4, play6, play7;
    ImageButton imgbut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);

        this.play = (LinearLayout) findViewById(R.id.utilisateur);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), UtilisateurActivity.class);
                startActivity(intent);
            }
        });

        this.play1 = (LinearLayout) findViewById(R.id.conge);
        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), CongeActivity.class);
                startActivity(intent);
            }
        });

        this.play3 = (LinearLayout) findViewById(R.id.demande);
        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), AjoutDemandeActivity.class);
                startActivity(intent);
            }
        });

        this.play4 = (LinearLayout) findViewById(R.id.suivi);
        play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), InfoDemandeActivity.class);
                startActivity(intent);
            }
        });

        this.play6 = (LinearLayout) findViewById(R.id.profils);
        play6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), ProfilsActivity.class);
                startActivity(intent);
            }
        });

        this.play7 = (LinearLayout) findViewById(R.id.mail);
        play7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), MailActivity.class);
                startActivity(intent);
            }
        });
    }

    public void deconnexion(View view) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
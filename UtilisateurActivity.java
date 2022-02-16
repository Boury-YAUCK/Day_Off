package com.example.day_off;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class UtilisateurActivity extends AppCompatActivity {

    private ImageView play, play1, play2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilisateur);

        this.play = (ImageView) findViewById(R.id.ajoutuser);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });

        this.play1 = (ImageView) findViewById(R.id.modifieruser);
        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), ModifierUserActivity.class);
                startActivity(intent);

            }
        });

        this.play2 = (ImageView) findViewById(R.id.supprimerUser);
        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SuppUserActivity.class);
                startActivity(intent);
            }
        });
    }
}
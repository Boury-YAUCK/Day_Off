package com.example.day_off;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2;
    Button play;
   // DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //db = new DatabaseHelper(this);
        e1 = (EditText)findViewById(R.id.identiiant);
        e2 = (EditText)findViewById(R.id.psswd);
        play = (Button)findViewById(R.id.login);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String identifiant = e1.getText().toString();
                String password = e2.getText().toString();
                //Boolean connexion = db.identifiantpassword(identifiant,password);
                //if (connexion==true)
                    //Toast.makeText(getApplicationContext(),"vous etes bien connecté", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(getApplicationContext(), DashbordActivity.class);
                startActivity(intent);
                finish();



                //  Toast.makeText(getApplicationContext(),"identifiant ou mot de passe invalide", Toast.LENGTH_SHORT).show();
                // Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                //startActivity(intent);
            }
        });
    }



}
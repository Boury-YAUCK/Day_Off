package com.example.day_off;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.HashMap;

public class InfoDemandeActivity extends AppCompatActivity {

    EditText editTextButCni, editTextButPrenom, editTextButDteDemande, editTextButDepart, editTextButRetour, editTextButNbrjr, editTextButNom;
    Spinner SpinnerButType;
    Button buttonValider,buttonSupprimer;
    int position;
    Params p = new Params();
    HashMap<String,String>m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_demande);

        editTextButCni =(EditText) findViewById(R.id.butcni);
        editTextButNom =(EditText)findViewById(R.id.butnom);
        editTextButDteDemande =(EditText) findViewById(R.id.butdtedmande);
        SpinnerButType =(Spinner) findViewById(R.id.buttype);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerButType.setAdapter(adapter);
        //SpinnerButType.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        editTextButDepart =(EditText) findViewById(R.id.butdepart);
        editTextButRetour =(EditText) findViewById(R.id.butretour);
        editTextButNbrjr =(EditText) findViewById(R.id.butnbrjr);
        buttonValider =(Button)findViewById(R.id.butvalider);
        buttonSupprimer = (Button) findViewById(R.id.butsupprimer);

        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            position= extras.getInt("position");

        }

         m = p.values.get(position);
        editTextButCni.setText(m.get("cni"));
        editTextButNom.setText(m.get("prenom"));
        editTextButDteDemande.setText(m.get("date"));
        //SpinnerButType.setText(m.get("type"));
        editTextButDepart.setText(m.get("depart"));
        editTextButRetour.setText(m.get("retour"));
        editTextButNbrjr.setText(m.get("nbrjr"));

        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.put("cni",editTextButCni.getText().toString());
                m.put("prenom",editTextButNom.getText().toString());
                m.put("date",editTextButDteDemande.getText().toString());
                m.put("type",(String) SpinnerButType.getItemAtPosition(0));
                m.put("depart",editTextButDepart.getText().toString());
                m.put("retour",editTextButRetour.getText().toString());
                m.put("nbrjr",editTextButNbrjr.getText().toString());
                Intent i = new Intent(getApplicationContext(), ListDemande.class);
                startActivity(i);
                finish();
            }
        });

        buttonSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                p.values.remove(position);
                Intent i = new Intent(getApplicationContext(), ListDemande.class);
                startActivity(i);
                finish();
            }
        });
    }
}
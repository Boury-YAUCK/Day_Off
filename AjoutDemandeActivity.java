package com.example.day_off;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class AjoutDemandeActivity extends AppCompatActivity {


    EditText cni,nom, date, motif,  depart, retour,type, nbrjr;
    Button adddemande;

    ProgressDialog dialog;
    JSONParser parser= new JSONParser();
    int success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_demande);

        cni=findViewById(R.id.cni);
        nom=findViewById(R.id.nom);
        motif=findViewById(R.id.motif);
        type=findViewById(R.id.type);
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.type, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //type.setAdapter(adapter);
        //SpinnerButType.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        depart=findViewById(R.id.depart);
        retour=findViewById(R.id.retour);
        nbrjr=findViewById(R.id.nbrjr);
        adddemande=findViewById(R.id.adddemande);
        adddemande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new adddemande().execute();
            }
        });
    }
    class adddemande extends AsyncTask<String,String,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog=new ProgressDialog(AjoutDemandeActivity.this);
            dialog.setMessage("Patientez svp");
            dialog.show();
        }



        @Override
        protected String doInBackground(String... strings) {

            HashMap<String,String> map = new HashMap<String,String>();
            map.put("cni", cni.getText().toString());
            map.put("nom", nom.getText().toString());
            map.put("date", date.getText().toString());
            map.put("type", type.getText().toString());
            //map.put("type", (String) type.getItemAtPosition(0));
            map.put("motif", motif.getText().toString());
            map.put("depart", depart.getText().toString());
            map.put("retour", retour.getText().toString());
            map.put("nbrjr", nbrjr.getText().toString());

            JSONObject object = parser.makeHttpRequest("http://192.168.43.50/dayoffrh/adddemande.php", "GET",map);
            try {
                success=object.getInt("success");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dialog.cancel();

            if(success==1){

                Toast.makeText(AjoutDemandeActivity.this , "ajout effectué", Toast.LENGTH_SHORT).show();
            }

            else {
                Toast.makeText(AjoutDemandeActivity.this , "echec !!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}



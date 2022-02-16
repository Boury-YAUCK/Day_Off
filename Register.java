package com.example.day_off;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Register extends AppCompatActivity {


    EditText editTextButNom, editTextButPrenom, editTextButMail, editTextButCni, editTextButTel, editTextButAdd,
            editTextButVille, editTextButNaiss, editTextButDep, editTextButFonction, editTextButContrat, editTextButEntre,
            editTextButId, editTextButPassword, editTextButPassword2;
    RadioGroup editTextRadioSexe, editTextRadioMatri;
    Button b1;

    ProgressDialog dialog;
    JSONParser parser= new JSONParser();
    int success;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextButNom =(EditText)findViewById(R.id.butnom);
        editTextButMail =(EditText)findViewById(R.id.butmail);
        editTextRadioSexe =(RadioGroup) findViewById(R.id.radiosexe);
        editTextButCni =(EditText)findViewById(R.id.butcni);
        editTextRadioMatri =(RadioGroup) findViewById(R.id.radiomatri);
        editTextButTel =(EditText)findViewById(R.id.buttel);
        editTextButAdd =(EditText)findViewById(R.id.butadd);
        editTextButNaiss =(EditText)findViewById(R.id.butnaiss);
        editTextButDep =(EditText)findViewById(R.id.butdepartema);
        editTextButFonction =(EditText)findViewById(R.id.butfonction);
        editTextButContrat =(EditText)findViewById(R.id.buttypcontrat);
        editTextButEntre =(EditText)findViewById(R.id.butentre);
        editTextButId =(EditText)findViewById(R.id.butidentifiant);
        editTextButPassword =(EditText)findViewById(R.id.butpassword);
        editTextButPassword2 =(EditText)findViewById(R.id.butpassword2);

        b1=(Button)findViewById(R.id.btnajouter);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Add().execute();
            }
        });
    }
        class Add extends AsyncTask<String,String,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                dialog=new ProgressDialog(Register.this);
                dialog.setMessage("Patientez svp");
                dialog.show();
            }

            @Override
            protected String doInBackground(String... strings) {

                HashMap<String,String> map = new HashMap<String,String>();

                map.put("editTextButNom",editTextButNom.getText().toString());
                map.put("editTextButMail",editTextButMail.getText().toString());
                map.put("editTextRadioSexe",editTextRadioSexe.getClass().toString());
                map.put("editTextButCni",editTextButCni.getText().toString());
                map.put("editTextRadioMatri",editTextRadioMatri.getClass().toString());
                map.put("editTextButTel",editTextButTel.getText().toString());
                map.put("editTextButAdd",editTextButAdd.getText().toString());
                map.put("editTextButNaiss",editTextButNaiss.getText().toString());
                map.put("editTextButDep",editTextButDep.getText().toString());
                map.put("editTextButFonction",editTextButFonction.getText().toString());
                map.put("editTextButContrat",editTextButContrat.getText().toString());
                map.put("editTextButEntre",editTextButEntre.getText().toString());
                map.put("editTextButId",editTextButId.getText().toString());
                map.put("editTextButPassword",editTextButPassword.getText().toString());
                map.put("editTextButPassword2",editTextButPassword2.getText().toString());

                JSONObject object = parser.makeHttpRequest("http://192.168.43.50/dayoffrh/add.php", "GET",map);

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

                    Toast.makeText(Register.this , "ajout effectué", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(Register.this , "echec !!!!", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }
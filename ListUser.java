package com.example.day_off;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class ListUser extends AppCompatActivity {
    ListView ls;
    String nom, mail, cni, sexe, matri,tel, adresse, naissance, department,fonction, type, arrive, identif,password;
    HashMap<String,String> map;
    Params p = new Params();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        ls=findViewById(R.id.lst);

        Bundle extras=getIntent().getExtras();
        if (extras!=null){
            cni=extras.getString("cni");
            nom=extras.getString("nom");
            mail=extras.getString("mail");
            type=extras.getString("type");
            sexe=extras.getString("sexe");
            arrive=extras.getString("retour");
            matri=extras.getString("matri");
            tel=extras.getString("tel");
            adresse=extras.getString("adresse");
            naissance=extras.getString("naissance");
            department=extras.getString("department");
            fonction=extras.getString("fonction");
            identif=extras.getString("identif");
            password=extras.getString("password");
            map=new HashMap<String, String>();
            map.put("butnom", nom);
            map.put("butmail", mail);
            map.put("butcni", cni);
            map.put("radiosexe", sexe);
            map.put("radiomatri", matri);
            map.put("buttel", tel);
            map.put("butadd", adresse);
            map.put("butnaiss", naissance);
            map.put("butdepartema", department);
            map.put("butfonction", fonction);
            map.put("buttypcontrat", type);
            map.put("butentre", arrive);
            map.put("butidentifiant", identif);
            map.put("butpassword", password);

            p.values.add(map);

        }
        SimpleAdapter adapter = new SimpleAdapter(ListUser.this, p.values, R.layout.item,
                new String[]{"nom", "mail", "cni", "sexe", "matri","tel", "adresse", "naissance", "department","fonction", "type", "arrive", "identif","password"},
                new int[]{R.id.butnom,R.id.butmail,R.id.butcni,R.id.radiosexe,R.id.radiomatri,R.id.buttel,R.id.butadd,R.id.butnaiss,R.id.butdepartema,R.id.butfonction,R.id.buttype,R.id.butentre,R.id.butidentifiant,R.id.butpassword,});
        ls.setAdapter(adapter);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent i = new Intent(getApplicationContext(), ModifierUserActivity.class);
                i.putExtra("position", position);
                startActivity(i);

            }
        });
    }
}
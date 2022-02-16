package com.example.day_off;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class ListDemande extends AppCompatActivity {

    ListView ls;
    String cni, prenom, date, type, depart, arrive, nbrjr;
    HashMap<String,String> map;
    Params p = new Params();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_demande);

        ls=findViewById(R.id.lst);

        Bundle extras=getIntent().getExtras();
        if (extras!=null){
            cni=extras.getString("cni");
            prenom=extras.getString("prenom");
            date=extras.getString("date");
            type=extras.getString("type");
            depart=extras.getString("depart");
            arrive=extras.getString("retour");
           nbrjr=extras.getString("nbrjr");
           map=new HashMap<String, String>();
           map.put("cni", cni);
            map.put("prenom", prenom);
            map.put("date", date);
            map.put("type", type);
            map.put("depart", depart);
            map.put("retour", arrive);
            map.put("nbrjr", nbrjr);

            p.values.add(map);

        }
        SimpleAdapter adapter = new SimpleAdapter(ListDemande.this, p.values, R.layout.item,
                new String[]{"cni","prenom","date","type","depart","retour","nbrjr"},
                new int[]{R.id.cni,R.id.prenom,R.id.date,R.id.type,R.id.depart,R.id.arrive,R.id.nbrjr,});
        ls.setAdapter(adapter);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent i = new Intent(getApplicationContext(), InfoDemandeActivity.class);
                i.putExtra("position", position);
                startActivity(i);

            }
        });
    }
}
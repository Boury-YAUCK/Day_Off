package com.example.day_off;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class CongeActivity extends AppCompatActivity {

    String techList[]= {"Conge Annuel", "Conge maladie", "Conges speciaux", "Calendrier"};
    String des[]= {"Description", "Description", "Description", "Description"};
    int techImages[]= {R.drawable.periode, R.drawable.congesmaladie, R.drawable.time, R.drawable.conge};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conge);

        listView = (ListView) findViewById(R.id.customListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), techList,des, techImages);
        listView.setAdapter(customBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    startActivity(new Intent(CongeActivity.this,Annuel.class));
                }

                else if (position == 1){
                    startActivity(new Intent(CongeActivity.this,MaladieActivity.class));
                }

                else if (position == 2){
                    startActivity(new Intent(CongeActivity.this,Speciaux.class));
                }

                else if (position == 3){
                    startActivity(new Intent(CongeActivity.this,Calendrier.class));
                }


            }
        });

        /*this.annuel = (TextView)findViewById(R.id.conAnnuel);
        annuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Annuel.class);
                startActivity(intent);
            }
        });

        this.affich = (TextView)findViewById(R.id.affich);
        affich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Calendrier.class);
                startActivity(intent);
            }
        });

        this.maladie = (TextView)findViewById(R.id.conMaladie);
        maladie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MaladieActivity.class);
                startActivity(intent);
            }
        });*/
    }
}
package com.example.day_off;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class RevoirDemandeActivity extends AppCompatActivity {

    private ListView listdemande;
    private Button btnList;
    private DatabaseHelper bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revoir_demande);

        bd = new DatabaseHelper(this);
        btnList = (Button)findViewById(R.id.rvwrdmnde);
        listdemande= (ListView)findViewById(R.id.listrvwr);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String demande="";
                List<String> list = bd.getAlldemande();
                for (int i = 0; i <list.size() ; i++) {
                    demande+=list.get(i)+"\n\n";
                }
                ArrayAdapter userArrayAdapter = new ArrayAdapter<>(RevoirDemandeActivity.this, android.R.layout.simple_list_item_1, list);
                listdemande.setAdapter(userArrayAdapter);
                //Toast.makeText(ModifierUserActivity.this, USER).show();
            }
        });
    }
}

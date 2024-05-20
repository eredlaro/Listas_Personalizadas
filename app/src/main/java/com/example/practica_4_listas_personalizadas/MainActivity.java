package com.example.practica_4_listas_personalizadas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.List);
        String[] nombres={"Manzana","Naranja","Uva","Fresa","Durazno"};
        String[] precios ={"40","50","30","70","90"};
        Integer[]  idimage= {R.drawable.manzana,R.drawable.naranja,R.drawable.uva,R.drawable.fresa,R.drawable.durazno};
        AdapterList adapter = new AdapterList(this,nombres,precios,idimage);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Seleccionaste el elemento: "+nombres[position], Toast.LENGTH_LONG).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),": "+nombres[position]+"con precio de :$"+precios[position], Toast.LENGTH_LONG).show();
            return true;
            }

        });
    }
}
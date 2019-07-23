package com.example.lapto.aplicacionpersonal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;


public class proyectoindividual extends AppCompatActivity {
EditText ET_tema,ET_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyectoindividual);
        ET_tema =(EditText) findViewById(R.id.ET_tema);
        ET_link =(EditText) findViewById(R.id.ET_link);
    }

    public void GuardarDatos(View view){
        String tema = ET_tema.getText()/toString();
        String link = ET_link.getText()/toString();

        BaseHelper baseHelper = new BaseHelper(this,"DEMODB",null,1);
        SQLiteDatabase db = baseHelper.getWritableDatabase();
        if(db !=null){
            ContentValues registronuevo = new ContentValues();
            registronuevo.put("TEMA",tema);
            registronuevo.put("Link",link);
            long i = db.insert ("ENLACESPORTEMA",null,registronuevo);
            if(i>0){
                Toast.makeText(this,"Registro Insertado",Toast.LENGTH_SHORT).show();

            }

        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().Inflate(R.menu.menu_main,menu);
        return true;
    }



}

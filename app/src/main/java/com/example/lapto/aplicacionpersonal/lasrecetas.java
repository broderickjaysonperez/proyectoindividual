package com.example.lapto.aplicacionpersonal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class lasrecetas extends SQLiteOpenHelper {

    //creo las variable
    private static final String NOMBRE_BD="lasrecetas.bd";
    private  static final int VERSION_BD=1;
//nos servira para guardar los datos del formulario
    private static final String TABLA_RECETAS="CREATE TABLE RECETAS(CODIGO TEXT PRIMARY KEY, RECETA TEXT,LINK TEXT)";

    public lasrecetas(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }


    //hare el metodo create


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_RECETAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_RECETAS);
        sqLiteDatabase.execSQL(TABLA_RECETAS);

    }

    //AHORA SE ENCARGARA DE GUARDAR LOS REGISTROS

    public void  agregarRecetas(String codigo, String receta, String link){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("INSERT INTO RECETAS VALUES('"+codigo+"','"+receta+"','"+link+"')");
            bd.close();
        }
    }
}

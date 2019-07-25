package com.example.recetasconlink;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.autofill.AutofillManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.StringReader;
import java.net.ResponseCache;
import java.net.URL;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText txtcodigo,txtreceta,txtlink;
    Button btnbuscar,btnagregar,btneditar,btneliminar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtcodigo=(EditText)findViewById(R.id.txtid);
        txtreceta=(EditText)findViewById(R.id.txtreceta);
        txtlink=(EditText)findViewById(R.id.txtlink);

        btnagregar=(Button)findViewById(R.id.btnagregar);
        // btneditar=(Button)findViewById(R.id.btneditar);
        //   btneliminar=(Button)findViewById(R.id.btneliminar);
        //  btnbuscar=(Button)findViewById(R.id.btnbuscar);


        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejecutarservicio("htpp://192.168.1.46:8080/recetaconlink/insertar_receta.php");
            }
        });

    }
    //metodo q enviara peticion al servidor

    private void ejecutarservicio(String URL){

        StringRequest stringRequest = new  StringRequest(Request.Method.POST,URL,new Response.Listener<String>() {
            @override
            public void cnResponse(String response) {
                Toast.makeText(getApplicationContext(), "operacion exitosa", Toast.LENGTH_SHORT).show();
            }
        },new Response.ErrorListener(){
            @override
            public void cnErrorResponse(VolleyError error){
                Toast.makeText(gerAplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @override
            protected Map<String,String>getparams() throws AutofailureError{
                parametros.put ("codigo",txtcodigo.getText().toString());
                parametros.put ("receta",txtreceta.getText().toString());
                parametros.put ("link",txtlink.getText().toString());

                return parametros;
            }
        };

        //para q sea leida y solicitud
        RequeastQueue requeastQueue=Volley.newRequestQueue(context this);
        requestQueue.add(stringRequest);


    }
}

package com.example.lapto.aplicacionpersonal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText txtcodigo,txtreceta,txtlink;
    Button btnagregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtcodigo=(EditText)findViewById(R.id.txtcodigo);
        txtreceta=(EditText)findViewById(R.id.txtreceta);
        txtlink=(EditText)findViewById(R.id.txtlink);
        btnagregar=(Button) findViewById(R.id.btnagregar);
//hacer la instancia para hacer uso de la clase

        final  lasrecetas lasrecetas=new lasrecetas(getApplicationContext());
//are el evento click

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lasrecetas.agregarRecetas(txtcodigo.getText().toString(),txtreceta.getText().toString(),txtlink.getText().toString());
//VERIFICAR SI C AGREGO CORRECTAMENTE
                Toast.makeText(getApplicationContext(),"SE AGREGO CORRECTAMENTE",Toast.LENGTH_SHORT);
            }
        });

    }
}

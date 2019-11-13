package com.example.pmdmut2sharedtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;


public class MainActivity extends AppCompatActivity {
    //elementos app
    private EditText textBoxApellido;
    private EditText textBoxNombre;
    private Button botonGuardar;
    private Button botonSaludar;
    //valores
    private String nombre;
    private String apellido;

    private SharedPreferences.Editor editorPreferencias;
    private SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textBoxNombre = (EditText)findViewById(R.id.textBoxNombre);
        textBoxApellido=(EditText)findViewById(R.id.textBoxApellido);
        botonGuardar=(Button)findViewById(R.id.botonGuardar);
        botonSaludar=(Button)findViewById(R.id.botonSaludar);

        //Objeto preferencias
        final SharedPreferences preferencias = getSharedPreferences("datos",Context.MODE_PRIVATE);
       /*preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        //Editor
        editorPreferencias = preferencias.edit();*/


      botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Editor
                SharedPreferences.Editor editor= preferencias.edit();
                editor.putString("nombre",textBoxNombre.getText().toString());
                editor.putString("apellido",textBoxApellido.getText().toString());
                //con commit guardamos los datos
                editor.commit();
                Toast.makeText(MainActivity.this,"Datos guardados correctamente",Toast.LENGTH_SHORT).show();
            }
        });

        botonSaludar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
               /* editorPreferencias.putString("nombre",textBoxNombre.getText().toString());
                editorPreferencias.putString("apellido",textBoxApellido.getText().toString());
                editorPreferencias.commit(); */
                nombre=preferencias.getString("nombre","nombre por defecto");
                apellido=preferencias.getString("apellido","apellido por defecto");
                Toast.makeText(MainActivity.this,"Hola, " +nombre+" "+apellido, LENGTH_LONG).show();
            }
        });
    }
}

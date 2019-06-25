package com.example.hellosharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     TextView txtView;
     EditText editNombre;
     Button btnRecuperar;
    //Paso1.- crea una variable para llamar a applicationPreferences
     private ApplicationPreferences appPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView  = findViewById(R.id.obtNombre);
        editNombre  = findViewById(R.id.nombre);
        btnRecuperar = findViewById(R.id.btnRecu);
        //Paso2.- llama al metodo singleton para poder usar applicationPreferences
        appPref.init(getApplicationContext());
        // Paso 4.- carga el valor intoducido em el textView y al iniciar la app de nuevo sale con el ultimo valor
        txtView.setText(appPref.loadName());


        //LLAMA A LA CLASE APLLICATIONPREFERENCES
        ApplicationPreferences.init(getApplicationContext());

        // GUARDAR EN MI BASE DE DATOS
        ApplicationPreferences.saveName("Lolita");

        //RECUPERA EL NOMBRE D ELA BASE DE DATOS
        String recuperarNombre = ApplicationPreferences.loadName();


        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //Paso 3.- Llama a los metodos de la clase ApplicationPreferences
                // Primero llamas al metodo SaveName y guarda el nombre que intoduzco
                appPref.saveName(editNombre.getText().toString());
                // Actualizar el valor textview
                txtView.setText(editNombre.getText().toString());

            }
        });
    }

}

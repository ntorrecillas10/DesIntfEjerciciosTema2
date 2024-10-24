package com.example.desintfejerciciostema2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var nombre: TextInputEditText
    private lateinit var edad:  TextInputEditText
    private lateinit var nombreLayout: TextInputLayout
    private lateinit var boton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //seteo las variables
        nombre = findViewById(R.id.Edit1text)
        edad = findViewById(R.id.Edit2text)
        nombreLayout = findViewById(R.id.Edit1)

        //seteamos el evento de click del boton

        boton = findViewById(R.id.Button1boton)

        boton.setOnClickListener{
            Log.d("MainActivity", "Nombre: ${nombre.text}")
            Log.d("MainActivity", "Edad: ${edad.text}")

            //comprobamos nombre no es empty y al menos tenga 2 caracteres
            if (nombre.text.toString().isNotEmpty() || nombre.text.toString().length <= 2){
                nombreLayout.error = "El nombre debe tener al menos 2 caracteres"
            }else{
                Log.d("MainActivity", "Boton pulsado")
            }

        }

    }
}
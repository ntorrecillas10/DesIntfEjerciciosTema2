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
    private lateinit var correo:  TextInputEditText
    private lateinit var pass: TextInputEditText
    private lateinit var nombreLayout: TextInputLayout
    private lateinit var correoLayout: TextInputLayout
    private lateinit var passLayout: TextInputLayout
    private lateinit var boton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //seteo las variables
        nombre = findViewById(R.id.Edit1text)
        correo = findViewById(R.id.Edit2text)
        pass = findViewById(R.id.Edit3text)
        nombreLayout = findViewById(R.id.Edit1)
        correoLayout = findViewById(R.id.Edit2)
        passLayout = findViewById(R.id.Edit3)
        boton = findViewById(R.id.Button1boton)

        boton.setOnClickListener{
            Log.d("MainActivity", "Nombre: ${nombre.text}")
            Log.d("MainActivity", "Correo: ${correo.text}")
            Log.d("MainActivity", "Pass: ${pass.text}")


            var contador  = 0

            //comprobamos nombre no es empty y al menos tenga 2 caracteres
            if (nombre.text.toString().isNotEmpty() && nombre.text.toString().length <= 2){
                nombreLayout.error = "El nombre debe tener al menos 2 caracteres"
            }else{
                Log.d("MainActivity", "Boton pulsado")
                nombreLayout.error=null
                contador++
            }
            if (pass.text.toString().length <= 6){
                passLayout.error = "La contraseña debe tener al menos 6 caracteres"
            }else {
                passLayout.error = null
                contador++
            }
            if (!correo.text.toString().contains("@")){
                correoLayout.error = "El correo no es válido"
            }
            else{
                correoLayout.error=null
                contador++
            }
            if (!correo.text.toString().contains(".")){
                correoLayout.error = "El correo no es válido"
            }
            else{
                correoLayout.error=null
            }
        if (contador == 3){
            //ponemos todos los textos a 0
            nombre.setText("")
            correo.setText("")
            pass.setText("")
        }

        }

    }
}
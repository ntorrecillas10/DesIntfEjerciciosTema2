package com.example.desintfejerciciostema2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Ejercicio3 : AppCompatActivity() {


    private lateinit var correo: TextInputEditText
    private lateinit var correoLayout: TextInputLayout
    private lateinit var pass: TextInputEditText
    private lateinit var passLayout: TextInputLayout
    private lateinit var nombre: TextInputEditText
    private lateinit var nombreLayout: TextInputLayout
    private lateinit var cp: TextInputEditText
    private lateinit var cpLayout: TextInputLayout
    private lateinit var fecha: TextInputEditText
    private lateinit var fechaLayout: TextInputLayout
    private lateinit var boton: Button


    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        //seteo las variables
        correo = findViewById(R.id.TextCorreo)
        correoLayout = findViewById(R.id.EditCorreo)
        pass = findViewById(R.id.TextPass)
        passLayout = findViewById(R.id.EditPass)
        nombre = findViewById(R.id.TextNombre)
        nombreLayout = findViewById(R.id.EditNombre)
        cp = findViewById(R.id.TextCP)
        cpLayout = findViewById(R.id.EditCP)
        fecha = findViewById(R.id.TextFecha)
        fechaLayout = findViewById(R.id.EditFecha)
        boton = findViewById(R.id.Button1boton)



        fecha.setOnClickListener {
            val builder = MaterialDatePicker.Builder.datePicker()
            val picker = builder.build()

            picker.addOnPositiveButtonClickListener {
                fecha.setText(picker.headerText)
            }
            picker.show(supportFragmentManager, picker.toString())
        }




        boton.setOnClickListener {

            //Hacemos que el correo solo sea valido si tiene @gmail.com al final
            if (correo.text.toString().contains("@gmail.com")) {
                correoLayout.error = null
                //Si esta bien ponemos el cuadro en verde
                correoLayout.boxStrokeColor = getColor(R.color.green)
                //Ponemos el color del texto en verde
                correoLayout.defaultHintTextColor = getColorStateList(R.color.green)
            } else {
                correoLayout.error = "El correo no es válido"
            }
            //Contraseña obligatoria, con más de 7 carácteres y debe contener un numero, una mayuscula y una minuscula
            if (pass.text.toString().length >= 7 && pass.text.toString()
                    .contains("[A-Z]".toRegex()) && pass.text.toString()
                    .contains("[a-z]".toRegex()) && pass.text.toString().contains("[0-9]".toRegex())
            ) {
                passLayout.error = null
                //Si esta bien ponemos el cuadro en verde
                passLayout.boxStrokeColor = getColor(R.color.green)
                //Ponemos el color del texto en verde
                passLayout.defaultHintTextColor = getColorStateList(R.color.green)

            } else {
                passLayout.error = "Debe tener al menos 7 carácteres, una mayús, un min y un num"

            }
            //Si el nombre no está vacío ponemos el cuadro en verde
            if (nombre.text.toString().isNotEmpty() && nombre.text.toString().length > 1) {
                nombreLayout.error = null
                nombreLayout.boxStrokeColor = getColor(R.color.green)
                nombreLayout.defaultHintTextColor = getColorStateList(R.color.green)
            } else if (nombre.text.toString().isEmpty()) {
                nombreLayout.error = null
            } else {
                nombreLayout.error = "Mínimo 2 caracteres"
            }
            //El CP no es obligatorio pero si se pone debe ser válido (5 dígitos) y el numero debe ser menos a 50000


            if (cp.text.toString().length == 5 && cp.text.toString().toInt() < 50000) {
                cpLayout.error = null
                cpLayout.boxStrokeColor = getColor(R.color.green)
                cpLayout.defaultHintTextColor = getColorStateList(R.color.green)
            } else {
                cpLayout.error = "Ingrese un CP correcto"

            }
            //La fecha debe ser menor a 18 años antes que hoy
            if (fecha.text.toString().isNotEmpty()) {
                val fechaNacimiento = fecha.text.toString()
                val fechaActual = System.currentTimeMillis()
                val fechaNacimientoMillis = fechaNacimiento.toLong()
                val edad = (fechaActual - fechaNacimientoMillis) / (1000 * 60 * 60 * 24 * 365)
                if (edad < 18) {
                    fechaLayout.error = null
                    fechaLayout.boxStrokeColor = getColor(R.color.green)
                    fechaLayout.defaultHintTextColor = getColorStateList(R.color.green)
                }else{
                    fechaLayout.error = "Debe ser mayor de edad"
                }




            }


        }










    }
}
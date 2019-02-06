package com.example.mjg70.proyectomoviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_opciones.*

class OpcionesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)
        editText.setText(intent.getStringExtra("usuarioId"))
        btnHistorial.setOnClickListener { irHistorial() }
        btnEnfermedad.setOnClickListener { irEnfermedad() }
        btnTratamiento.setOnClickListener { irTratamiento() }
    }

    fun irHistorial(){
        var intent = Intent(this, HistorialActivity::class.java)
        intent.putExtra("usuario", editText.text.toString())
        startActivity(intent)
    }
    fun irEnfermedad(){
        var intent = Intent(this, EnfermedadActivity::class.java)
        startActivity(intent)
    }
    fun irTratamiento(){
        var intent = Intent(this, TratamientoActivity::class.java)
        startActivity(intent)
    }


}

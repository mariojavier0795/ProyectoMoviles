package com.example.mjg70.proyectomoviles

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_historial.*

class HistorialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)
        btnAcepHis.setOnClickListener { guardarHistorial() }
    }

    fun guardarHistorial (){
        val url = "http://172.17.1.226:1337/historial"
        val historial = Historial(codigoHistorial = txtCodHistorial.text.toString(),
                                  fecha = txtFechaHistorial.text.toString(),
                                    observaciones = txtObservaciones.text.toString()
            )
        val parametro=listOf("codigoHistorial" to historial.codigoHistorial,
                              "fecha" to historial.fecha,
                                "observaciones" to historial.observaciones)
        url.httpPost(parametro).responseString { request, response, result ->
            when(result){
                is Result.Failure ->{
                    val exepcion = result.getException()
                    Toast.makeText(this, "Error:${exepcion}", Toast.LENGTH_SHORT).show()
                }
                is Result.Success -> {
                    Toast.makeText(this, "Ingreso exitoso", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

}

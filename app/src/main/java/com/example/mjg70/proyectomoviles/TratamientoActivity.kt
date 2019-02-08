package com.example.mjg70.proyectomoviles

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_historial.*
import kotlinx.android.synthetic.main.activity_tratamiento.*

class TratamientoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tratamiento)
        btnAcepTra.setOnClickListener { guardarTratamiento() }
    }
    fun guardarTratamiento () {
        val url = "http://172.17.1.226:1337/tratamiento"
        val tratamiento = Tratamiento(
            codigoTratamiento = txtCodTra.text.toString(),
            usoTratamiento = txtUsoTrat.text.toString(),
            observacionTratamiento = txtObsTra.text.toString()
        )
        val parametro = listOf(
            "codigoTratamiento" to tratamiento.codigoTratamiento,
            "usoTratamiento" to tratamiento.usoTratamiento,
            "observacionTratamiento" to tratamiento.observacionTratamiento
        )
        url.httpPost(parametro).responseString { request, response, result ->
            when (result) {
                is Result.Failure -> {
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

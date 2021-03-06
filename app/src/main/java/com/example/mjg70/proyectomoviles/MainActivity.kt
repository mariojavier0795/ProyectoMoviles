package com.example.mjg70.proyectomoviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnIngresar.setOnClickListener { consultarIngreso() }
    }
fun consultarIngreso(){
    val lstUsuario = ArrayList<Usuario>()
    val url = "http://172.17.1.226:1337/usuario"
    val usuario = Usuario(cedula= null ,nombre=txtNombre.text.toString(), apellido = null,
        direccion = null, password = null, edad = null)
    val parametro=listOf("nombre" to usuario.nombre)
    url.httpGet(parametro).responseString { request, response, result ->
        when(result){
            is Result.Failure ->{
                val exepcion = result.getException()
                Toast.makeText(this, "Error:${exepcion}", Toast.LENGTH_SHORT).show()
            }
            is Result.Success -> {
               val resultado = result.get()
               val jsonResultado= Klaxon().parseArray<Usuario>(resultado)
                if (jsonResultado!= null) {
                    var intent =Intent(this, OpcionesActivity::class.java)
                    startActivity(intent)
                }

            }

            }
        }
}

}

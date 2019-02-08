package com.example.mjg70.proyectomoviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_enfermedad.*
import kotlinx.android.synthetic.main.activity_main.*

class EnfermedadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enfermedad)
        val adapter = ArrayAdapter<Enfermedad>(
            this,
            android.R.layout.simple_list_item_1,
            llenarEnfermedades()
        )
        lstEnfermedad.adapter = adapter;
    }


    fun llenarEnfermedades():ArrayList<Enfermedad>{
        var listaEnfermedad = ArrayList<Enfermedad>()
        val url = "http://172.17.1.226:1337/enfermedad"
        url.httpGet().responseString { request, response, result ->
            when(result){
                is Result.Failure ->{
                    val exepcion = result.getException()
                    Toast.makeText(this, "Error:${exepcion}", Toast.LENGTH_SHORT).show()
                }
                is Result.Success -> {
                    val resultado = result.get()
                    val jsonResultado= Klaxon().parseArray<Enfermedad>(resultado)
                    if (jsonResultado!= null) {
                        for(item in jsonResultado.iterator()){
                            listaEnfermedad.add(item)
                        }
                    }

                }

            }
        }
        return listaEnfermedad
    }

}

package com.uesvaz.miniagendarecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.endevinaelnumero.ContactAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val vista = findViewById<RecyclerView>(R.id.vistaContactos)

        vista.layoutManager = LinearLayoutManager(this)
        vista.adapter = ContactAdapter(contactos)


    }
    val contactos = mutableListOf<Contact>()




}
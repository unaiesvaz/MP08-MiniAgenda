
package com.uesvaz.miniagendarecyclerview

import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.endevinaelnumero.ContactAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val contactos = mutableListOf<Contact>()

        val vista = findViewById<RecyclerView>(R.id.vistaContactos)
        val boton = findViewById<FloatingActionButton>(R.id.buttonContactos)

        // Generamos 40 contactos aleatorios
        repeat(40) {

            val nombre = nombres.random()
            val apellido = apellidos.random()

            val nombreCompleto = nombre + " " + apellido

            val telefono = (600000000..699999999).random().toString()

            val contacto = Contact(nombreCompleto, telefono)

            contactos.add(contacto)
        }

        // Configuramos el RecyclerView
        val adapter = ContactAdapter(contactos)

        vista.layoutManager = LinearLayoutManager(this)
        vista.adapter = adapter

        // Boton para añadir contactos
        boton.setOnClickListener {

            val campoNombre = EditText(this)
            campoNombre.hint = "Introduce el nombre"

            val campoTelefono = EditText(this)
            campoTelefono.hint = "Introduce el telefono"

            val layout = LinearLayout(this)
            layout.orientation = LinearLayout.VERTICAL

            layout.addView(campoNombre)
            layout.addView(campoTelefono)

            val builder = AlertDialog.Builder(this)

            builder.setTitle("Nuevo contacto")
            builder.setView(layout)

            builder.setPositiveButton("Aceptar") { dialog, which ->

                val nombre = campoNombre.text.toString()
                val telefono = campoTelefono.text.toString()

                val nuevoContacto = Contact(nombre, telefono)

                adapter.agregarContacto(nuevoContacto)
            }

            builder.setNegativeButton("Cancelar") { dialog, which ->

            }

            val dialog = builder.create()
            dialog.show()
        }
    }

    // Generacion de nombres y apellidos
    val nombres = arrayOf(
        "Unai", "Alex", "Marc", "David", "Carlos",
        "Javier", "Mario", "Daniel", "Pablo", "Adrian"
    )

    val apellidos = arrayOf(
        "Escobar", "Garcia", "Losada", "Lopez", "Martinez",
        "Sanchez", "Perez", "Fernandez", "Gomez", "Ruiz"
    )
}

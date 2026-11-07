package com.example.endevinaelnumero

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uesvaz.miniagendarecyclerview.Contact
import com.uesvaz.miniagendarecyclerview.R

class ContactAdapter(val contactos: MutableList<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    // Clase para identificar los elementos visuales
    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nombre = itemView.findViewById<TextView>(R.id.tvName)
        val telefono = itemView.findViewById<TextView>(R.id.tvPhone)

    }

    // Crear los elementos del RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        val vista = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)

        return ContactViewHolder(vista)
    }

    // Introducir los datos de cada contacto
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

        val contacto = contactos[position]

        holder.nombre.text = contacto.name
        holder.telefono.text = contacto.phone

    }

    // Devolver el numero de contactos
    override fun getItemCount(): Int {
        return contactos.size
    }

    fun agregarContacto(contacto: Contact) {
        contactos.add(contacto)
        notifyItemInserted(contactos.size - 1)
    }
}
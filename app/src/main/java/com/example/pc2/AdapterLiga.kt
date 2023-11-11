package com.example.pc2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pc2.DataBase.LigaEntity

class AdapterLiga(private val ligas: List<LigaEntity>) : RecyclerView.Adapter<LigaViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LigaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return LigaViewHolder(view)
    }

    override fun onBindViewHolder(holder: LigaViewHolder, position: Int) {
        val liga = ligas[position]

        holder.nombreTextView.text = liga.nombre
        //holder.nombreTextView = liga.año
        holder.titulosTextView.text = liga.titulos
    }

    override fun getItemCount(): Int = ligas.size

}
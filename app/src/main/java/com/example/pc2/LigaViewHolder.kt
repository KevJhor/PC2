package com.example.pc2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LigaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.image)
    val nombreTextView: TextView = itemView.findViewById(R.id.txtNom)
    val titulosTextView: TextView = itemView.findViewById(R.id.txtTitul)
}
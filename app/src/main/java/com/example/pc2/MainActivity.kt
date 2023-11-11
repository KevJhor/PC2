package com.example.pc2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.pc2.DataBase.LigaEntity
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: LigaViewModel
    private lateinit var db: FirebaseFirestore
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = FirebaseFirestore.getInstance()
        val textNombre: EditText = findViewById(R.id.txtNom)
        val textAño: EditText = findViewById(R.id.textAño)
        val textTitulos: EditText = findViewById(R.id.txtTitulos)
        val textURL: EditText = findViewById(R.id.txtImage)
        val btnGuardar: Button = findViewById(R.id.btnGuardar)

        btnGuardar.setOnClickListener {
            val ligaEntity = LigaEntity(
                nombre = textNombre.text.toString(),
                año = textAño.text.toString(),
                titulos = textTitulos.text.toString(),
                url = textURL.text.toString()
            )

            // Agrega los datos de la liga a Firebase.
            db.collection("ligas").add(ligaEntity)
        }

        db.collection("ligas").addSnapshotListener { snapshots, e ->
            if (e != null) {
                // Se produjo un error al consultar la colección.
                return@addSnapshotListener
            }
            for (dc in snapshots!!.documentChanges) {
                when (dc.type) {
                    DocumentChange.Type.ADDED, DocumentChange.Type.MODIFIED -> {
                        // Se agregó o modificó un documento.
                        // Actualiza la interfaz de usuario con los datos del nuevo documento.
                    }

                    DocumentChange.Type.REMOVED -> {
                        // Se eliminó un documento.
                        // Actualiza la interfaz de usuario para reflejar la eliminación del documento.
                    }

                    else -> {
                        // Se produjo un error al consultar la colección.
                    }
                }
            }
        }



    }


}
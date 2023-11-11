package com.example.pc2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pc2.DataBase.LigaEntity
import com.example.pc2.DataBase.LigaRepository
import com.google.firebase.firestore.FirebaseFirestore

class LigaViewModel: ViewModel()  {

    private val db = FirebaseFirestore.getInstance()
    private val _ligas = MutableLiveData<List<LigaEntity>>()

    init {
        db.collection("ligas").addSnapshotListener { snapshots, e ->
            if (e != null) {
                // Se produjo un error al consultar la colección.
                return@addSnapshotListener
            }

            val ligas = mutableListOf<LigaEntity>()
            for (snapshot in snapshots!!) {
                val liga = snapshot.toObject(LigaEntity::class.java)
                ligas.add(liga)
            }

            _ligas.value = ligas
        }
    }

    fun getLigas(): LiveData<List<LigaEntity>> {
        return _ligas
    }
}
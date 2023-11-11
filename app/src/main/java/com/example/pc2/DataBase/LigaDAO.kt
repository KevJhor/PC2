package com.example.pc2.DataBase

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


interface LigaDAO {
    @Insert
    fun insert(customerEntity: LigaEntity)
    @Update

    fun update(customerEntity: LigaEntity)
    @Delete
    fun delete(customerEntity: LigaEntity)

    @Query("SELECT * FROM liga ORDER BY titulos_ganados")
    fun getLigaByTitulos(): LiveData<List<LigaEntity>>

}
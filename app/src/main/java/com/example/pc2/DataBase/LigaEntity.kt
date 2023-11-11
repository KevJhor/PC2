package com.example.pc2.DataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("liga")
data class LigaEntity(
    @ColumnInfo("nombre") var nombre: String?,
    @ColumnInfo("año_fundacion") var año: String?,
    @ColumnInfo("titulos_ganados") var titulos: String?,
    @ColumnInfo("URL") var url: String?
){
    @PrimaryKey(true)
    @ColumnInfo("Liga_id") var ligaID: Int = 0
}

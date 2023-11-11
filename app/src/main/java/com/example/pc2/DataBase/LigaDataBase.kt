package com.example.pc2.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities= [LigaEntity::class], version = 1)
abstract class LigaDataBase: RoomDatabase(){

    abstract fun ligaDao(): LigaDAO

    companion object {
        private const val DATABASE_NAME = "sales"
        @Volatile
        private var INSTANCE: LigaDataBase?=null

        fun getInstance(context: Context): LigaDataBase?{
            INSTANCE?: synchronized(this){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    LigaDataBase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }
}
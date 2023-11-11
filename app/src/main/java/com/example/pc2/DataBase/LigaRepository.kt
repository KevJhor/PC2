package com.example.pc2.DataBase

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LigaRepository(application: Application) {

    private val ligDao:
            LigaDAO? = LigaDataBase
        .getInstance(application)?.ligaDao()
    fun insert(customerEntity: LigaEntity){
        if(ligDao!=null)
            InsertAsyncTask(ligDao).execute(customerEntity)
    }
    fun getEquipos(): LiveData<List<LigaEntity>> {
        return ligDao?.getLigaByTitulos() ?: MutableLiveData<List<LigaEntity>>().apply{
            value = emptyList()
        }
    }

    private class InsertAsyncTask
        (private val liDao: LigaDAO): AsyncTask<LigaEntity, Void, Void>(){
        override fun doInBackground(vararg customers: LigaEntity?): Void? {
            for(customer in customers){
                if(customer!=null)
                    liDao.insert(customer)
            }
            return null
        }
    }
}
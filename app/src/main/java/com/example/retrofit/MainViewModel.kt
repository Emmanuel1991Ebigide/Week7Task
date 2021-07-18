package com.example.retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel: ViewModel() {

    val items: MutableLiveData<List<ItemModel>> = MutableLiveData()
    val Students: MutableLiveData<List<StudentModel>> = MutableLiveData()

    fun getAllItems() {
        CoroutineScope(Dispatchers.IO).launch {
            val item: List<ItemModel> = RetrofitProvider.service.getAllItems()
            items.postValue(item)
        }
    }

    fun getAllStudents(){
        CoroutineScope(Dispatchers.IO).launch {
            val students: List<StudentModel> = RetrofitProvider.service2.getAllStudents()
            Students.postValue(students)
        }
    }
}
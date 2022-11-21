package com.example.advancedtopics.ViewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.advancedtopics.DataClass.QuoteList
import com.example.advancedtopics.DataClass.Result
import com.example.advancedtopics.Helpers.RetrofitHelper
import com.example.advancedtopics.Interfaces.RetrofitEndPoints
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitViewModel: ViewModel() {


    val liveDataList: MutableLiveData<List<com.example.advancedtopics.DataClass.Result>> by lazy {
        MutableLiveData<List<com.example.advancedtopics.DataClass.Result>>()
    }

//

    fun makeApiCall(){


        viewModelScope.launch (Dispatchers.IO){
            var quotesApi = RetrofitHelper.getInstance().create(RetrofitEndPoints::class.java)
            var call =  quotesApi.getQuotes().body()?.results
            liveDataList.postValue(call)
        }

    }


}
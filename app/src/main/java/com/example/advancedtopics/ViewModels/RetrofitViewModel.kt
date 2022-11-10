package com.example.advancedtopics.ViewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advancedtopics.DataClass.QuoteList
import com.example.advancedtopics.DataClass.Result
import com.example.advancedtopics.Helpers.RetrofitHelper
import com.example.advancedtopics.Interfaces.RetrofitEndPoints
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitViewModel: ViewModel() {
    var authorName: String = "empty"
    var authorQuote: String = "empty"
    var longLine:String = ""

    // New Attempt //

    lateinit var liveDataList: MutableLiveData<List<com.example.advancedtopics.DataClass.Result>>
    init {
        liveDataList = MutableLiveData()
    }
    fun getLiveDataObserver():MutableLiveData<List<com.example.advancedtopics.DataClass.Result>>{

        return liveDataList
    }

    fun makeApiCall(){
        val quotesApi = RetrofitHelper.getInstance().create(RetrofitEndPoints::class.java)
        val call =  quotesApi.getQuotes5()
        call.enqueue(object : Callback<List<com.example.advancedtopics.DataClass.Result>>{
            override fun onFailure(call: Call<List<Result>>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(call: Call<List<Result>>, response: Response<List<Result>>) {
                liveDataList.postValue(response.body())
            }
        })

    }

    // New Attempt //







    // Fine // Returns author name //
    fun getApiAuthorName(index: Int): String{
        val quotesApi = RetrofitHelper.getInstance().create(RetrofitEndPoints::class.java)
        // launching a new coroutine

        CoroutineScope(Dispatchers.IO).launch {
            val result = quotesApi.getQuotes()
            if (result != null)
            // Checking the results
                authorName = result.body()?.results?.get(index)?.author.toString()
        }

        return authorName
    }

    fun getApiAuthorQuote(index: Int): String{

        val quotesApi = RetrofitHelper.getInstance().create(RetrofitEndPoints::class.java)
        // launching a new coroutine
        CoroutineScope(Dispatchers.IO).launch {
            val result = quotesApi.getQuotes()
            if (result != null)
            // Checking the results
                authorQuote = result.body()?.results?.get(index)?.content.toString()
        }
        return authorQuote
    }

    fun oneBigLump(): String{
        val quotesApi = RetrofitHelper.getInstance().create(RetrofitEndPoints::class.java)
        // launching a new coroutine
        CoroutineScope(Dispatchers.IO).launch {
            val result = quotesApi.getQuotes()
            if (result != null)
            // Checking the results
                longLine = result.body()?.toString().toString()
        }
        return longLine

    }




    fun handFullOfAuthorNames(index: Int): ArrayList<com.example.advancedtopics.DataClass.Result>{
        var list: ArrayList<com.example.advancedtopics.DataClass.Result> = ArrayList()


        for(i in 1..index){
            var name1: String = getApiAuthorName(i)
            Log.d("TAG", name1)
            var quote1: String = getApiAuthorQuote(i)

            list.add(com.example.advancedtopics.DataClass.Result("", name1,"",quote1,"","",null,null))
        }

        return list
    }



}
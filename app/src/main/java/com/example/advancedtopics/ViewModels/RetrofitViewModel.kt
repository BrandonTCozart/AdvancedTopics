package com.example.advancedtopics.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.advancedtopics.Classes.AuthorQuote
import com.example.advancedtopics.Helpers.RetrofitHelper
import com.example.advancedtopics.Interfaces.RetrofitEndPoints
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RetrofitViewModel: ViewModel() {
    var authorName: String = ""

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
                authorName = result.body()?.results?.get(index)?.content.toString()
        }
        return authorName
    }

    fun handFullOfAuthorNames(index: Int): ArrayList<AuthorQuote>{
        var list: ArrayList<AuthorQuote> = ArrayList()

        for(i in 0..index){
            list.add(AuthorQuote(getApiAuthorName(i), getApiAuthorQuote(i)))
        }

        return list
    }

}
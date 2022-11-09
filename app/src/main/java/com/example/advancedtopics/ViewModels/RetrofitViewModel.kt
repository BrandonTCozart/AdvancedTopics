package com.example.advancedtopics.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.advancedtopics.DataClass.AuthorQuote
import com.example.advancedtopics.Helpers.RetrofitHelper
import com.example.advancedtopics.Interfaces.RetrofitEndPoints
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RetrofitViewModel: ViewModel() {
    var authorName: String = "empty"
    var authorQuote: String = "empty"
    var longLine:String = ""



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




    fun handFullOfAuthorNames(index: Int): ArrayList<AuthorQuote>{
        var list: ArrayList<AuthorQuote> = ArrayList()


        for(i in 1..index){
            var name1: String = getApiAuthorName(i)
            Log.d("TAG", name1)
            var quote1: String = getApiAuthorQuote(i)

            list.add(AuthorQuote(name1, quote1))
        }

        return list
    }



}
package com.example.advancedtopics.Interfaces

import com.example.advancedtopics.DataClass.QuoteList
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitEndPoints {

    @GET("/quotes")
    suspend fun getQuotes() : Response<QuoteList>

    @GET("/quotes1")
    suspend fun getQuotes1() : Response<QuoteList>

    @GET("/quotes2")
    suspend fun getQuotes2() : Response<QuoteList>

}
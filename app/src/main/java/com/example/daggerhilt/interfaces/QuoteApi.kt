package com.example.daggerhilt.interfaces

import android.graphics.pdf.PdfDocument.Page
import com.example.daggerhilt.models.ApiResponseQuoteModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    @GET("/quotes")
   fun getQuotes(@Query("page") page: Int): Call<ApiResponseQuoteModel>

    @GET("/quotes")
   suspend fun getQuote(@Query("page") page: Int): ApiResponseQuoteModel

}
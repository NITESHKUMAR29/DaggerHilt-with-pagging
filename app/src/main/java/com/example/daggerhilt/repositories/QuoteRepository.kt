package com.example.daggerhilt.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.daggerhilt.interfaces.QuoteApi
import com.example.daggerhilt.models.ApiResponseQuoteModel
import com.example.daggerhilt.models.QuoteModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val quoteApi: QuoteApi) {

    fun getQuote(
        page: Int,
        data: MutableLiveData<ApiResponseQuoteModel>,
        error: MutableLiveData<Throwable>
    ) {
        quoteApi.getQuotes(page).enqueue(object :Callback<ApiResponseQuoteModel>{
            override fun onResponse(
                call: Call<ApiResponseQuoteModel>,
                response: Response<ApiResponseQuoteModel>
            ) {
                if (response.body()!=null){
                    data.value=response.body()
                }
                else{
                    data.value=null
                }
            }

            override fun onFailure(call: Call<ApiResponseQuoteModel>, t: Throwable) {
               error.value=t
            }

        })
    }

    fun getQuoteList(
    ): LiveData<PagingData<QuoteModel>> {
        Log.d("nk/dataaa","enter2")
           return Pager(
                config = PagingConfig(20,100),
                pagingSourceFactory = {
                    QuotePagingSource(
                        quoteApi
                    )
                }
            ).liveData

    }

}
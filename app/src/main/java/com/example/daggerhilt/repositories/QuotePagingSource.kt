package com.example.daggerhilt.repositories

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.daggerhilt.interfaces.QuoteApi
import com.example.daggerhilt.models.QuoteModel

class QuotePagingSource(private val quoteApi: QuoteApi) : PagingSource<Int, QuoteModel>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, QuoteModel> {
        Log.d("nk/dataaa","enter4")

        return try {
            val position = params.key ?: 1
            val response = quoteApi.getQuote(position)
            Log.d("nk/dataaa",response.results.toString())
            LoadResult.Page(
                data = response.results,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position==response.totalPages) null else position+1
            )


        } catch (e: Exception) {
            Log.d("nk/dataaaerr",e.message.toString())
            LoadResult.Error(e)
        }
    }




    @ExperimentalPagingApi
    override fun getRefreshKey(state: PagingState<Int, QuoteModel>): Int? {
        Log.d("nk/dataaa","enter4")

        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    }

}
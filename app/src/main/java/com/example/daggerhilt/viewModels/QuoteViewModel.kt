package com.example.daggerhilt.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.daggerhilt.models.ApiResponseQuoteModel
import com.example.daggerhilt.repositories.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(private val repository: QuoteRepository):ViewModel(){

    private val data=MutableLiveData<ApiResponseQuoteModel>()
    private val error=MutableLiveData<Throwable>()

    fun getData(page:Int):LiveData<ApiResponseQuoteModel>{
        repository.getQuote(page,data,error)
        return data
    }

    val list=repository.getQuoteList().cachedIn(viewModelScope)

}
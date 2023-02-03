package com.example.daggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerhilt.adapter.PagingAdapter
import com.example.daggerhilt.databinding.ActivityMainBinding
import com.example.daggerhilt.viewModels.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PagingAdapter


    private lateinit var viewModel:QuoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= ViewModelProvider(this)[QuoteViewModel::class.java]
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        val randomNumber=(Math.random()*10).toInt()
//        viewModel.getData(randomNumber).observe(this){
//            binding.text.text=it.results.toString()
//        }

        adapter = PagingAdapter()

       binding. recyclerview.layoutManager = LinearLayoutManager(this)
        binding. recyclerview.setHasFixedSize(true)
        binding. recyclerview.adapter = adapter


        viewModel.list.observe(this){
            Log.d("nk/dataaa",it.toString())


            adapter.submitData(lifecycle,it)

        }
    }
}
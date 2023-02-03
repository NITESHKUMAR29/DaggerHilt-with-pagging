package com.example.daggerhilt.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.daggerhilt.R
import com.example.daggerhilt.models.QuoteModel

class PagingAdapter():PagingDataAdapter<QuoteModel,PagingAdapter.QuoteViewHolder>(QuoteModel.diffUtil) {


    class QuoteViewHolder(itemView:View):ViewHolder(itemView){
        val text:TextView=itemView.findViewById(R.id.quoteText)
        val author:TextView=itemView.findViewById(R.id.author)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        Log.d("nk/datas","enter")
            val item=getItem(position)
        if (item != null) {
            holder.text.text="'"+item.content+"'"
            holder.author.text=item.author
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
      val  view= LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return QuoteViewHolder(view)
    }



}
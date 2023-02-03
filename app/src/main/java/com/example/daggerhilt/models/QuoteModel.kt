package com.example.daggerhilt.models

import androidx.recyclerview.widget.DiffUtil
import java.io.Serializable

data class QuoteModel(
    var _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
    val tags: List<String>
):Serializable{
    companion object{
        val diffUtil=object : DiffUtil.ItemCallback<QuoteModel>(){
            override fun areItemsTheSame(oldItem: QuoteModel, newItem: QuoteModel): Boolean {
                return oldItem._id==newItem._id
            }

            override fun areContentsTheSame(oldItem: QuoteModel, newItem: QuoteModel): Boolean {
                return oldItem==newItem
            }

        }
    }
}


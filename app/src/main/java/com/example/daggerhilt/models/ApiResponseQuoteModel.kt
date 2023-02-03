package com.example.daggerhilt.models

data class ApiResponseQuoteModel(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<QuoteModel>,
    val totalCount: Int,
    val totalPages: Int
)
package com.example.newslykotlincompose.data.remote

data class ArticleResponse(
    val articles: List<ArticleDto>,
    val status: String,
    val totalResults: Int
)
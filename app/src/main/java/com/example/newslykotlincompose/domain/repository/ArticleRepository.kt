package com.example.newslykotlincompose.domain.repository

import com.example.newslykotlincompose.data.remote.ArticleResponse
import retrofit2.Response

interface ArticleRepository {
    suspend fun getArticles(): Response<ArticleResponse>
}
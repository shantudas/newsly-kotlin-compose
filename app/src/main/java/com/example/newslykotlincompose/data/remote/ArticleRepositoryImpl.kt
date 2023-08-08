package com.example.newslykotlincompose.data.remote

import com.example.newslykotlincompose.domain.repository.ArticleRepository
import retrofit2.Response

class ArticleRepositoryImpl(
    private val api: ArticleApi,
) : ArticleRepository {
    override suspend fun getArticles(): Response<ArticleResponse> {
        return api.getTopHeadlines()
    }
}
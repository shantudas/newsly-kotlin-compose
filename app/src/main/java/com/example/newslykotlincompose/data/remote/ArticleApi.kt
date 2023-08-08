package com.example.newslykotlincompose.data.remote

import com.example.newslykotlincompose.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApi {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<ArticleResponse>

    companion object {
        const val BASE_URL = "https://newsapi.org/"
    }
}